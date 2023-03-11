package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.addinn.data.kaddem.entities.Departement;
import tn.addinn.data.kaddem.entities.Etudiant;
import tn.addinn.data.kaddem.entities.Universite;

import java.util.List;
import java.util.Optional;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {

    Optional<Universite> findUniversiteByIdUniv(Integer integer);






}
