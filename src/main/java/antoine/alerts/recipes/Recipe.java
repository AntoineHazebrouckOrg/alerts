package antoine.alerts.recipes;

import java.util.List;

import lombok.Data;

@Data
public final class Recipe {
	private final String name;
	private final List<String> ingredients;

	public static RecipeBuilder named(String name) {
		return new RecipeBuilder(name);
	}
	// public Recipe(String name, String... ingredients) {
	// 	this.name = name;
	// 	this.ingredients = Stream.of(ingredients).toList();
	// }

	// private Recipe(String name, List<String> ingredients) {
	// 	this.name = name;
	// 	this.ingredients = ingredients;
	// }
}
