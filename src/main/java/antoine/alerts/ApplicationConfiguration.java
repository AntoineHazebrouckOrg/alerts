package antoine.alerts;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Setter(value = AccessLevel.PRIVATE)
@Data
@ConfigurationProperties(prefix = "application")
public class ApplicationConfiguration {
	private String receiver;
}
