package antoine.alerts.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import antoine.alerts.data.recipes.Recipe;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
@Service
public class RecipeReaderService {
	public List<Recipe> read() throws IOException {
		val content = Files.readString(Paths.get("runtime-resources/recipes.md"));
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
