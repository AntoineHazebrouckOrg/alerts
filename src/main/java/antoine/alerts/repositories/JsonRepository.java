package antoine.alerts.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Cleanup;
import lombok.val;

abstract class JsonRepository<T> {
	private static final ObjectMapper json = new ObjectMapper();

	public final List<T> findAll() throws IOException {
		@Cleanup
		val reader = new FileInputStream(file());

		val content = reader.readAllBytes();
		val type = json.getTypeFactory().constructCollectionType(ArrayList.class, clazz());
		return json.readValue(content, type);
	}

	public final T save(T element) throws IOException {
		val allData = findAll();
		allData.add(element);

		@Cleanup
		val writer = new FileOutputStream(file());

		writer.write(json.writeValueAsBytes(allData));

		return element;
	}

	protected abstract File file();

	protected abstract Class<T> clazz();
}
