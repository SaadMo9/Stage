package net.guides.springboot2.springboot2jpacrudexample.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiels")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMateriel;
    private String materieltype;
    private String n_serie;
    private String garantie;
    private String description;

}
