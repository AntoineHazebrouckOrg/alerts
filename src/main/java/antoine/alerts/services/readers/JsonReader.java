package antoine.alerts.services.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.val;

abstract class JsonReader<T> {
	public final List<T> read() throws IOException {
		ObjectMapper json = new ObjectMapper();

		val content = Files.readString(Paths.get(path()));
		val type = json.getTypeFactory().constructCollectionType(ArrayList.class, clazz());
		return json.readValue(content, type);
	}

	protected abstract String path();
	protected abstract Class<T> clazz();
}
