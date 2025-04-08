package antoine.alerts.senders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import antoine.alerts.recipes.Recipe;
import antoine.alerts.services.EmailService;
import antoine.alerts.services.RecipeReaderService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RandomRecipeSender implements Sender {
	private final EmailService email;
	private final RecipeReaderService recipes;

	@Scheduled(cron = "0 0 10,18 * * *")
	@Override
	public void send() throws Exception {
		var copy = new ArrayList<>(recipes.read());
		Collections.shuffle(copy);
		Recipe random = copy.get(0);

		email.to("antoine.haz@gmail.com")
				.subject("Recette : " + random.getName())
				.body("Recette : " + random.getName() + "\n - "
						+ random.getIngredients().stream()
								.collect(Collectors.joining("\n - ")))
				.send();
	}

}
