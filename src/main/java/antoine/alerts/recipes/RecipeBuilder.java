package antoine.alerts.recipes;

import java.util.ArrayList;
import java.util.List;

class RecipeBuilder {
	private final String name;
	private final List<String> ingredients;

	public RecipeBuilder(String name) {
		this.name = name;
		this.ingredients = new ArrayList<>();
	}

	public RecipeBuilder needs(String ingredient) {
		ingredients.add(ingredient);
		return this;
	}

	public Recipe build() {
		return new Recipe(name, ingredients);
	}
}
