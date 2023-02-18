package tn.addinn.data.kaddem.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.services.IContratServices;

import java.util.List;

@RestController
@RequestMapping("contrat")
@RequiredArgsConstructor
public class ContratController {

    private final IContratServices iContratServices;

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
}