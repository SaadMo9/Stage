package net.guides.springboot2.springboot2jpacrudexample.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "materiels")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMateriel;
    private String materieltype;
    private String n_serie;
    private String garantie;
    private String description;

    @OneToMany(
            targetEntity =net.guides.springboot2.springboot2jpacrudexample.model.Client.class,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<Client> clients;

    /* @OneToMany(mappedBy = "materiels")
    private List<Client> clients;*/

}
