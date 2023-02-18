package tn.addinn.data.kaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.addinn.data.kaddem.entities.Contrat;
import tn.addinn.data.kaddem.entities.Departement;

public interface ContratRepository extends JpaRepository<Contrat, Integer> {
}
