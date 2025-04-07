package antoine.alerts.recipes;

import java.util.List;

public class Recipes {
	private Recipes() {
	}

	public static final List<Recipe> all = List.of(
			Recipe.named("Poulet curry")
					.needs("poulet")
					.needs("curry")
					.needs("creme")
					.needs("riz")
					.build());
}
