package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.addinn.data.kaddem.entities.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

    @Query("select e from Etudiant e where e.nomE = ?1 and e.prenomE = ?2")
    Optional<Etudiant> getByNomEAndPrenomE(String nomE, String prenomE);
}

