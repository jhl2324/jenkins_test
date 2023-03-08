package test.cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class CicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CicdApplication.class, args);
	}

}
