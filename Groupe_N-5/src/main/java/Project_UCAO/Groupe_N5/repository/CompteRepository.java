package Project_UCAO.Groupe_N5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import Project_UCAO.Groupe_N5.entity.Compte;

@RepositoryRestResource
public interface CompteRepository  extends JpaRepository <Compte, Integer>{
    
}
