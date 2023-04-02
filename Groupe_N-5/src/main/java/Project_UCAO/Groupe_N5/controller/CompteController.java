package Project_UCAO.Groupe_N5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Project_UCAO.Groupe_N5.entity.Compte;
import Project_UCAO.Groupe_N5.service.CompteService;

@RestController
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping("/comptes")
    public List<Compte> getAll() {
        return compteService.showCompte();
    }

    @GetMapping("/comptes/{id}")
    public Compte get(@PathVariable Integer id) {
        return compteService.getOneCompte(id);
    }

    @PostMapping("/comptes")
    public Compte save(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte update(@PathVariable Integer id, @RequestBody Compte compte) {
        compte.setId(id);
        return compteService.saveCompte(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable Integer id) {
        compteService.deleteCompte(id);
    }
}
