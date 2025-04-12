package antoine.alerts.services.readers;

import org.springframework.stereotype.Service;

import antoine.alerts.data.recipes.Recipe;

@Service
public class RecipeReaderService extends JsonReader<Recipe> {

	@Override
	protected String path() {
		return "runtime-resources/recipes.json";
	}

	@Override
	protected Class<Recipe> clazz() {
		return Recipe.class;
	}
}
