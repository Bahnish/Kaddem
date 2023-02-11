package tn.addinn.data.kaddem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.addinn.data.kaddem.entities.Equipe;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.repositories.EtudiantRepository;
import tn.addinn.data.kaddem.services.IEtudiantServices;

import java.util.List;

@RestController
public class EtudiantController {
    @Autowired
    IEtudiantServices iEtudiantServices;
    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }
    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant(){
        return iEtudiantServices.getAllEtudiant();
    }
    @GetMapping("/getByIdEtudiant/{id}")
    public Etudiant getByIdEtudiant(@PathVariable int id){
        return iEtudiantServices.getByIdEtudiant(id);
    }
    @DeleteMapping("/deleteEtudiant/{id}")
    private void deleteEtudiant(@PathVariable int id){
        iEtudiantServices.deleteEtudiant(id);
    }
    @PostMapping("/ajouterEtudiant")
    public void ajouterEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantServices.ajouterEtudiant(etudiant);
    }
    @PutMapping("/updateEudiant")
    private Etudiant updateEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantServices.updateEtudiant(etudiant);
        return etudiant;
    }
}
