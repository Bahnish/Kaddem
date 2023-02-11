package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.addinn.data.kaddem.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
}
