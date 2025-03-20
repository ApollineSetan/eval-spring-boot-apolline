package com.example.apolline.evalspring.controller;

import com.example.apolline.evalspring.model.Categorie;
import com.example.apolline.evalspring.service.CategorieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    // Méthode qui retourne toutes les catégories
    @GetMapping("/categories")
    public Iterable<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    // Méthode qui retourne une catégorie par son ID
    @GetMapping("/categorie/{id}")
    public Categorie getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorie(id);
    }

    // Méthode qui ajoute une catégorie
    @PostMapping("/categorie/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie addCategorie(@Valid @RequestBody Categorie categorie) {
        return categorieService.addCategorie(categorie);
    }
}
