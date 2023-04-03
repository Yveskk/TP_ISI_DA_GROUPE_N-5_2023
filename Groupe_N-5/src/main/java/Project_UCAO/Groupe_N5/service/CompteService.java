package Project_UCAO.Groupe_N5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Project_UCAO.Groupe_N5.entity.Compte;
import Project_UCAO.Groupe_N5.repository.CompteRepository;

@Service
public class CompteService {
    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> showCompte() {
        return compteRepository.findAll();

    }

    public Compte getOneCompte(Integer id) {
        return compteRepository.findById(id).orElse(null);
    }

    public Compte saveCompte(Compte Compte) {
        return compteRepository.save(Compte);
    }

    public void deleteCompte(Integer id) {
        compteRepository.deleteById(id);
    }
}
