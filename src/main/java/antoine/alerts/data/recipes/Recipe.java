package antoine.alerts.data.recipes;

import java.util.List;

import lombok.Data;

@Data
public final class Recipe {
	private final String name;
	private final List<String> ingredients;

	public static RecipeBuilder named(String name) {
		return new RecipeBuilder(name);
	}
}
