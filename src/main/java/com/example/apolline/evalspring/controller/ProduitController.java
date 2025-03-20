package com.example.apolline.evalspring.controller;

import com.example.apolline.evalspring.model.Produit;
import com.example.apolline.evalspring.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    // Méthode qui retourne tous les produits
    @GetMapping("/produits")
    public Iterable<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    // Méthode qui retourne un produit par son ID
    @GetMapping("/produit/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    // Méthode qui ajoute un produit
    @PostMapping("/produit/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit addProduit(@Valid @RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }
}
