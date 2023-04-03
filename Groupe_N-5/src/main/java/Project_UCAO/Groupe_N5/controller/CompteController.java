package Project_UCAO.Groupe_N5.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Project_UCAO.Groupe_N5.entity.Client;
import Project_UCAO.Groupe_N5.entity.Compte;

import Project_UCAO.Groupe_N5.service.ClientService;
import Project_UCAO.Groupe_N5.service.CompteService;

@RestController
public class CompteController {
    @Autowired
    private CompteService compteService;
    @Autowired
    private ClientService clientService;
    

    @GetMapping("/comptes")
    public List<Compte> getAll() {
        return compteService.showCompte();
    }

    @GetMapping("/comptes/{id}")
    public Compte get(@PathVariable Integer id) {
        return compteService.getOneCompte(id);
    }

    @PostMapping("/comptes")
    public Compte save(@RequestParam("clientId") Integer clientId, @RequestBody Compte compte) {
        Client client = clientService.getOneClient(clientId);
        compte.setClient(client);
        compte.setSolde(0);
        compte.genereNumeroCompte();
        return compteService.saveCompte(compte);
    }

    
    @PutMapping("/comptes/depot/{id}")
    public Compte depot(@PathVariable Integer id, @RequestParam("somme")double somme) {
        Compte compte = compteService.getOneCompte(id);
        if(compte == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "compte trouvable");
        }
        compte.setSolde(compte.getSolde()+somme);
        return compteService.saveCompte(compte);
    }
    @PutMapping("/comptes/retirer/{id}")
    public Compte retrirer(@PathVariable Integer id, @RequestParam("somme")double somme) {
        Compte compte = compteService.getOneCompte(id);
        if(compte == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "compte trouvable");
        }
        if(compte.getSolde()< somme){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "solde insuffisant");
        }
        compte.setSolde(compte.getSolde()-somme);
        return compteService.saveCompte(compte);
    }
       @PutMapping("/comptes/transfer")
    public List<Compte> transfer(@RequestParam("IdEnvoyeur") Integer IdEnvoyeur,
            @RequestParam("IdReceveur") Integer IdReceveur, @RequestParam("somme") Double somme) {

        Compte compteEnvoyeur = compteService.getOneCompte(IdEnvoyeur);
        
        Compte compteReceveur = compteService.getOneCompte(IdReceveur);
        
        compteEnvoyeur.setSolde(compteEnvoyeur.getSolde()-somme);
        compteReceveur.setSolde(compteReceveur.getSolde()+somme);
        compteService.saveCompte(compteEnvoyeur);
        compteService.saveCompte(compteReceveur);
        List<Compte> comptes=new ArrayList<>();
        comptes.add(compteEnvoyeur);
        comptes.add(compteReceveur);
        return comptes;
    }
    @PutMapping("/comptes/{id}")
    public Compte update( @RequestParam("clientId") Integer clientId,@PathVariable Integer id, @RequestBody Compte detailCompte) {
        Compte compte = compteService.getOneCompte(id);
        Client client = clientService.getOneClient(clientId);
        compte.setClient(client);
        compte.setSolde(detailCompte.getSolde());
        return compteService.saveCompte(compte);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable Integer id) {
        compteService.deleteCompte(id);
    }

}
