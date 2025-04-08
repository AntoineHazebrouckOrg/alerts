package antoine.alerts;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
class AlertsApplication {

	public static void main(String[] args) throws BeansException, Exception {
		SpringApplication.run(AlertsApplication.class, args);
	}

}
