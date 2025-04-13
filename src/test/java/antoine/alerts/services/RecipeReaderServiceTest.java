package antoine.alerts.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import antoine.alerts.repositories.RecipeRepository;

@SpringBootTest
public class RecipeReaderServiceTest {
	@Autowired
	RecipeRepository repository;

	@Test
	void header_name() throws IOException {
		assertThat(repository.findAll().get(0).getName()).isEqualTo("Poulet curry");
		assertThat(repository.findAll().get(1).getName()).isEqualTo("Chachouka");
	}

	@Test
	void ingredients() throws IOException {
		assertThat(repository.findAll().get(0).getIngredients()).contains("poulet", "curry", "creme", "riz/pates");
		assertThat(repository.findAll().get(1).getIngredients()).contains("oignons", "poivrons", "tomates", "oeufs");
	}
}
