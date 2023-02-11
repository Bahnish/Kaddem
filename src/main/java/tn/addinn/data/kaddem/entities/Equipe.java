package tn.addinn.data.kaddem.entities;
import javax.persistence.*;
import java.util.List;

@Table( name = "equipe")
@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private int idEquipe;
    private String nomEquipe;


    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToOne
    private DetailEquipe detailEquipe;
    @ManyToMany
    private List<Etudiant> etudiants;

}
