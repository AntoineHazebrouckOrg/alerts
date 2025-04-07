package antoine.alerts.senders;

import org.springframework.stereotype.Service;

import antoine.alerts.services.EmailService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RentAlertSender implements Sender {
	private final EmailService email;

	@Override
	public void send() {
		email
				.to("antoine.haz@gmail.com")
				.subject("Rent")
				.body("Rent : 730€ to Mme.PLANCKAERT")
				.send();
	}
}
