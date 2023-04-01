package tn.addinn.data.kaddem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.services.IContratServices;
import tn.addinn.data.kaddem.services.IEtudiantServices;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("contrat")
@RequiredArgsConstructor
public class ContratController {

    private final IContratServices iContratServices;

    @Autowired
    private IEtudiantServices iEtudiantServices;

    @GetMapping()
    public List<Contrat> getAllContrat(){
        return iContratServices.getAllContrat();
    }
    @GetMapping("/{id}")
    public Contrat getByIdContrat(@PathVariable int id){
        return iContratServices.getByIdContrat(id);
    }
    @DeleteMapping("/{id}")
    private void deleteContrat(@PathVariable int id){
        iContratServices.deleteContrat(id);
    }
    @PostMapping("/ajouterContrat")
    public void ajouterContrat(@RequestBody Contrat contrat){
        iContratServices.ajouterContrat(contrat);
    }
    @PutMapping("/updateContrat")
    private Contrat updateContrat(@RequestBody Contrat contrat){
        iContratServices.updateContrat(contrat);
        return contrat;
    }
    @PostMapping("/affctation")
    Contrat affectContratToEtudiant (@RequestBody Contrat ce, @RequestBody String nom ,@RequestBody String prenomE){
        return iContratServices.affectContratToEtudiant(ce,nom,prenomE);
    };
    @GetMapping("/GetMontant")
    public Map<String,Float> getMontantContartEntreDeuxDate(int idUniv, Date startDate, Date endDate){
        return iContratServices.getMontantContartEntreDeuxDate(idUniv,startDate,endDate);
    };
    @GetMapping("/GetNbrC")
    Integer nbContratsValides(Date startDate, Date endDate){
        return iContratServices.nbContratsValides(startDate,endDate);
    };
    @PostMapping("/scheduler")

    String retrieveAndUpdateStatusContrat(){
        return iContratServices.retrieveAndUpdateStatusContrat();
    };

}