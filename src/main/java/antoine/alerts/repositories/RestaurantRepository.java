package antoine.alerts.repositories;

import java.io.File;

import org.springframework.stereotype.Repository;

import antoine.alerts.data.restaurants.Restaurant;

@Repository
public class RestaurantRepository extends JsonRepository<Restaurant> {

	@Override
	protected File file() {
		return new File("runtime-resources/restaurants.json");

	}

	@Override
	protected Class<Restaurant> clazz() {
		return Restaurant.class;
	}

}
