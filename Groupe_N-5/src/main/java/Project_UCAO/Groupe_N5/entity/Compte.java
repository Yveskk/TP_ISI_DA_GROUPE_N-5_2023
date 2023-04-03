package Project_UCAO.Groupe_N5.entity;



import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String  numeroCompte;
    private String type;
    private LocalDate dateCreation;
    private double solde;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @JsonProperty("clientId") 
        public Integer AvoirIdClient() {
            return  client.getId();
        }
    
    public void genereNumeroCompte() {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder numeroCompte = new StringBuilder();
        Random random = new Random();

        // Génère 5 caractères alphanumériques aléatoires
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(alphanumeric.length());
            numeroCompte.append(alphanumeric.charAt(index));
        }

        // Concatène l'année de creation du compte
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        numeroCompte.append(year);

        this.setNumeroCompte(numeroCompte.toString());
    }
}
