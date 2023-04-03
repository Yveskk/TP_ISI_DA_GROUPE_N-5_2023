package Project_UCAO.Groupe_N5;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Project_UCAO.Groupe_N5.entity.Client;
import Project_UCAO.Groupe_N5.entity.Compte;
import Project_UCAO.Groupe_N5.repository.ClientRepository;
import Project_UCAO.Groupe_N5.repository.CompteRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner start(ClientRepository clientRepository, CompteRepository compteRepository) {
		return args -> {
			Client client = clientRepository
					.save(new Client(1, "BOUILI", "Espoir", LocalDate.of(2004, 1, 6), "Masculin", "Agoe",
							"+228 91340587", "BouiliEspoir@gmail.com", "Togolais", null));
			compteRepository
					.save(new Compte(1, "hrfds", "Epargne", LocalDate.of(2022, 4, 3), 234000.0, client));
			compteRepository
					.save(new Compte(2, "hthst", "Courant", LocalDate.of(2022, 3, 3), 567000.0, client));

		};
	}

}
