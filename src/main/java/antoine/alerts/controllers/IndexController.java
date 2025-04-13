package antoine.alerts.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import antoine.alerts.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;

@RequestMapping("/")
@RequiredArgsConstructor
@Controller
public class IndexController {
	private final RecipeRepository recipeRepository;

	@GetMapping
	public String get(Model model) throws IOException {
		model.addAttribute("recipes", recipeRepository.findAll());

		return "index";
	}

}
