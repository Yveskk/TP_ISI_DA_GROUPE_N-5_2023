package Project_UCAO.Groupe_N5.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastName;
    private String firstName;
    private LocalDate birthDate;
    private String sex;
    private String adress;
    private String phoneNumber;
    private String email;
    private String nationalite;

    @OneToMany(mappedBy="client", cascade =CascadeType.ALL)
    private List<Account> accounts;

}
