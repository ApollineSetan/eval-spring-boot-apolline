package com.example.apolline.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "categorie")

public class Categorie {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libelle", nullable = false)
    @NotBlank(message = "Le libellé de la catégorie est obligatoire.")
    @Size(min = 2, max = 50, message = "Le libellé doit contenir au moins 2 caractères et ne pas excéder 50.")
    private String libelle;

    // Constructeurs
    public Categorie() {
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
