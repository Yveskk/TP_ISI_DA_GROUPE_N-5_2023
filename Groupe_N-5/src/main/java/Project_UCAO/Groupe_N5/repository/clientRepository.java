package Project_UCAO.Groupe_N5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Project_UCAO.Groupe_N5.entity.Client;

public interface clientRepository extends JpaRepository<Client, Integer>  {
    
}
