package antoine.alerts;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class AlertsApplication {

	public static void main(String[] args) throws BeansException, Exception {
		SpringApplication.run(AlertsApplication.class, args).getBean(Main.class).run();
	}

}
