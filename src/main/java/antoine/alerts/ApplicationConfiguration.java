package antoine.alerts;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Setter(value = AccessLevel.PACKAGE) // only spring should use setters
@Data
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationConfiguration {
	private String receiver;
}
