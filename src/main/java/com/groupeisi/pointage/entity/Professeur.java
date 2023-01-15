package com.groupeisi.pointage.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author MS GASSAMA
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private int etat;
}
