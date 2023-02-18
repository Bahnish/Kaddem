package tn.addinn.data.kaddem.entities;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idDepart;
    private String nomDepart;
    @OneToMany(mappedBy ="departement")
    private List<Etudiant> etudiants;
    @ManyToOne
    private Universite universite ;


}
