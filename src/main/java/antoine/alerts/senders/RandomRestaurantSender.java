package antoine.alerts.senders;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import antoine.alerts.ApplicationConfiguration;
import antoine.alerts.data.restaurants.Restaurant;
import antoine.alerts.repositories.RestaurantRepository;
import antoine.alerts.services.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RandomRestaurantSender implements Sender {
	private final EmailService email;
	private final RestaurantRepository restaurants;
	private final ApplicationConfiguration application;

	@Scheduled(cron = "0 0 18 1,15 * *")
	@Override
	public void send() throws Exception {
		log.info("Preparing recipe alert email to " + application.getReceiver());

		val copy = new ArrayList<>(restaurants.findAll());
		Collections.shuffle(copy);
		Restaurant random = copy.get(0);

		email.to(application.getReceiver())
				.subject("Restaurant : " + random.getName())
				.body("<h1>%s</h1>".formatted(random.getName()) + """
						<a href="%s">address</a>
								""".formatted(random.getMapsLink()))
				.send();

		log.info("Email sent");
	}

}
