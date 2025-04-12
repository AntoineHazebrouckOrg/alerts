package antoine.alerts.services;

import org.springframework.mail.javamail.JavaMailSender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.val;

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

	public void send() throws MessagingException {
		val message = mail.createMimeMessage();
		// SimpleMailMessage message = new SimpleMailMessage();
		message.setRecipients(MimeMessage.RecipientType.TO, to);
		message.setSubject(subject);
		message.setContent(body, "text/html; charset=utf-8");
		mail.send(message);
	}
}
