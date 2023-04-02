package Project_UCAO.Groupe_N5.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@Table(name = "tuto")
@AllArgsConstructor

public class Client {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
 /*   private LocalDate dateNaissance ;
    private String sexe;
    private String adresse;
    private String numeroTelephone;
    private String mail;
    private String nationalite;  */ 

    @OneToMany(mappedBy="client", cascade =CascadeType.ALL)
    private List<Compte> compte;
    

    
}
