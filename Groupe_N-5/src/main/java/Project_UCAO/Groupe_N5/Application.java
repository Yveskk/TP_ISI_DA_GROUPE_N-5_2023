package Project_UCAO.Groupe_N5;

import Project_UCAO.Groupe_N5.entity.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	public Application(){

	}
	public CommandLineRunner start(){
		return args -> {
			 
		};
	}


}

