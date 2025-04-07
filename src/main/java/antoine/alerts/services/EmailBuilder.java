package antoine.alerts.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailBuilder {
	private final JavaMailSender mail;

	private String to;
	private String subject;
	private String body;

	public EmailBuilder to(String to) {
		this.to = to;
		return this;
	}

	public EmailBuilder subject(String subject) {
		this.subject = subject;
		return this;
	}

	public EmailBuilder body(String body) {
		this.body = body;
		return this;
	}

	public void send() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		mail.send(message);
	}
}
