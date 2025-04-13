package antoine.alerts.repositories;

import java.io.File;

import org.springframework.stereotype.Repository;

import antoine.alerts.data.recipes.Recipe;

@Repository
public class RecipeRepository extends JsonRepository<Recipe> {

	@Override
	protected File file() {
		return new File("runtime-resources/recipes.json");
	}

	@Override
	protected Class<Recipe> clazz() {
		return Recipe.class;
	}
}
