package tn.addinn.data.kaddem.entities;

import javax.persistence.*;

@Table( name = "detailEquipe")
@Entity
public class DetailEquipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idDetailEquipe;
    private int salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;

}
