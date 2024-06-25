package htwberlin.HTWSportPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HtwSportPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtwSportPlannerApplication.class, args);
	}

}
