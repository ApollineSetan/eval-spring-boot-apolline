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

    // Association ManyToOne avec Categorie
    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

    // Constructeurs
    public Produit() {
    }

    public Produit(String nom, Double prix , Categorie categorie) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
