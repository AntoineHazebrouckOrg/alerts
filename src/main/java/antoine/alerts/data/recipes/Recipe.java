package antoine.alerts.data.recipes;

import java.util.List;

import lombok.Value;

@Value
public class Recipe {
	String name;
	List<String> ingredients;

	public static RecipeBuilder named(String name) {
		return new RecipeBuilder(name);
	}
}
