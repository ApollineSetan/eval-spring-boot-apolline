package com.example.apolline.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "produit")

public class Produit {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    @NotBlank(message = "Le nom du produit est obligatoire.")
    @Size(min = 3, max = 50, message = "Le nom doit être supérieur à 2 caractères et ne pas excéder 50.")
    private String nom;

    @Column(name = "prix", nullable = false)
    @NotNull(message = "Le prix du produit est obligatoire.")
    @Positive(message = "Le prix doit être supérieur à zéro.")
    private Double prix;

    // Constructeurs
    public Produit() {
    }

    public Produit(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}
