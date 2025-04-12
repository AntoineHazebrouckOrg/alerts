package antoine.alerts.services.readers;

import org.springframework.stereotype.Service;

import antoine.alerts.data.restaurants.Restaurant;

@Service
public class RestaurantReaderService extends JsonReader<Restaurant> {

	@Override
	protected String path() {
		return "runtime-resources/restaurants.json";
	}

	@Override
	protected Class<Restaurant> clazz() {
		return Restaurant.class;
	}

}
