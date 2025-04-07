package antoine.alerts.services;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {
	private final JavaMailSender mail;

	public EmailBuilder to(String to) {
		return new EmailBuilder(mail).to(to);
	}
}
