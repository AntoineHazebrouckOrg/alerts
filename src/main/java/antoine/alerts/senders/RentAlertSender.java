package antoine.alerts.senders;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import antoine.alerts.ApplicationConfiguration;
import antoine.alerts.services.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RentAlertSender implements Sender {
	private final EmailService email;
	private final ApplicationConfiguration application;

	@Scheduled(cron = "0 0 8,18 4,5 * *")
	@Override
	public void send() {
		log.info("Preparing rent alert email to " + application.getReceiver());

		email
				.to(application.getReceiver())
				.subject("Rent")
				.body("Rent : 730€ to Mme.PLANCKAERT")
				.send();

		log.info("Email sent");
	}
}
