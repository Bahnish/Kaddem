package tn.addinn.data.kaddem.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.addinn.data.kaddem.entities.Equipe;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.repositories.EtudiantRepository;
import tn.addinn.data.kaddem.services.IEtudiantServices;

import java.util.List;
@Tag(name ="test")
@RestController
@RequestMapping("etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantServices iEtudiantServices;

    @GetMapping("/getAllEtudiant")
    public List<Etudiant> getAllEtudiant(){
        return iEtudiantServices.getAllEtudiant();
    }
    @GetMapping("/{id}")
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

    @PutMapping("{etudiantId}/{departementId}")
    public void assignEtudiantToDepartement( @PathVariable Integer etudiantId, @PathVariable Integer departementId){
        iEtudiantServices.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @PostMapping ("/AddEtudiant")
    public void ADDEtudiant(@RequestBody Etudiant etudiant) {
        iEtudiantServices.ajouterEtudiant(etudiant);
    }

    @PostMapping("/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable Integer idContrat, @PathVariable Integer idEquipe) {
        return iEtudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);

    }

    @GetMapping("/getEtudDep/{idDep}")
    public List<Etudiant> getEtudiantsByDepartement(@RequestBody Integer idDepartement) {
        return iEtudiantServices.getEtudiantsByDepartement(idDepartement);
    }

}
