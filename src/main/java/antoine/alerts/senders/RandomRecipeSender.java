package antoine.alerts.senders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import antoine.alerts.ApplicationConfiguration;
import antoine.alerts.data.recipes.Recipe;
import antoine.alerts.services.EmailService;
import antoine.alerts.services.RecipeReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RandomRecipeSender implements Sender {
	private final EmailService email;
	private final RecipeReaderService recipes;
	private final ApplicationConfiguration application;

	@Scheduled(cron = "0 0 10,18 * * *")
	@Override
	public void send() throws Exception {
		log.info("Preparing recipe alert email to " + application.getReceiver());

		var copy = new ArrayList<>(recipes.read());
		Collections.shuffle(copy);
		Recipe random = copy.get(0);

		email.to(application.getReceiver())
				.subject("Recette : " + random.getName())
				.body("Recette : " + random.getName() + "\n - "
						+ random.getIngredients().stream()
								.collect(Collectors.joining("\n - ")))
				.send();

		log.info("Email sent");
	}

}
