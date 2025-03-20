package com.example.apolline.evalspring.service;

import com.example.apolline.evalspring.exception.CategorieAlreadyExistsException;
import com.example.apolline.evalspring.exception.CategorieNotFoundException;
import com.example.apolline.evalspring.exception.NoCategorieFoundException;
import com.example.apolline.evalspring.model.Categorie;
import com.example.apolline.evalspring.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    // Ajouter une catégorie
    public Categorie addCategorie(Categorie categorie) {
        if (categorieRepository.existsByLibelle(categorie.getLibelle())){
            throw new CategorieAlreadyExistsException(categorie);
        }
        return categorieRepository.save(categorie);
    }

    // Récupérer toutes les catégories
    public Iterable<Categorie> getAllCategories() {
        if (categorieRepository.count() == 0) {
            throw new NoCategorieFoundException();
        }
        return categorieRepository.findAll();
    }

    // Récupérer une catégorie par son ID
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException(id));
    }

}