package antoine.alerts.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import antoine.alerts.data.recipes.Recipe;
import antoine.alerts.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;

@RequestMapping("/recipes")
@RequiredArgsConstructor
@Controller
public class RecipesController {
	private static final String newRecipeAttribute = "recipe";

	private final RecipeRepository recipeRepository;

	@GetMapping
	public String get(Model model) throws IOException {
		model.addAttribute("recipes", recipeRepository.findAll());
		model.addAttribute(newRecipeAttribute, new Recipe());

		return "recipes";
	}

	@PostMapping
	public String post(@ModelAttribute(name = newRecipeAttribute) Recipe recipe, Model model) throws IOException {
		recipeRepository.save(recipe);

		return "redirect:recipes";
	}

}
