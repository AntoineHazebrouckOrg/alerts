package antoine.alerts.services;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import antoine.alerts.recipes.Recipe;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
@Service
public class RecipeReaderService {
	private final ResourceLoader resources;

	public List<Recipe> read() throws IOException {
		var content = new String(resources.getResource("classpath:recipes.md").getInputStream().readAllBytes());
		return Stream.of(content.split("# "))
				.filter(line -> !line.isBlank())
				.map(section -> {
					val name = section.lines().findFirst().orElseThrow().replace("# ", "");

					val ingredients = section.lines().filter(l -> l.startsWith("- ")).toList();
					val builder = Recipe.named(name);
					ingredients.forEach(i -> builder.needs(i.replace("- ", "")));
					return builder.build();
				})
				.toList();
	}
}
