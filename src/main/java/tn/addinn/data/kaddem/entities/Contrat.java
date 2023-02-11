package tn.addinn.data.kaddem.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Table ( name = "contrat")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contrat {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Setter(AccessLevel.NONE)
    private int idContrat;
    private LocalDate dateDebutContrat;
    private LocalDate dateFinContrat;
    private boolean archive;
    private int montantContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @ManyToOne
    private Etudiant etudiant;


}
