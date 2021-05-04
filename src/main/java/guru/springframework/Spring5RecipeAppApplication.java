package guru.springframework;

import guru.springframework.bootstrap.BootstrapData;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Spring5RecipeAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(Spring5RecipeAppApplication.class, args);

    }

}
