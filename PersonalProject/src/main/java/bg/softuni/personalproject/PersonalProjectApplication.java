package bg.softuni.personalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PersonalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalProjectApplication.class, args);
    }


}
