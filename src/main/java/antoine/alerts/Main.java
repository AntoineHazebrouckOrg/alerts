package antoine.alerts;

import java.util.Set;

import org.springframework.stereotype.Component;

import antoine.alerts.senders.Sender;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class Main {
	private final Set<Sender> senders;

	public void run() throws Exception {
		for (Sender sender : senders) {
			sender.send();
		}
	}
}
