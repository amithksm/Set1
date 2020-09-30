package mongo.basic.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class MongoBasicApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MongoBasicApplication.class, args);
		System.out.println("Spring Release is "+SpringVersion.getVersion());
	}

}
