package com.example.apolline.evalspring.service;

import com.example.apolline.evalspring.exception.NoProduitFoundException;
import com.example.apolline.evalspring.exception.ProduitAlreadyExistsException;
import com.example.apolline.evalspring.exception.ProduitNotFoundException;
import com.example.apolline.evalspring.model.Produit;
import com.example.apolline.evalspring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    // Ajouter un produit
    public Produit addProduit(Produit produit) {
        if (produitRepository.existsByNom(produit.getNom())) {
            throw new ProduitAlreadyExistsException(produit);
        }
        return produitRepository.save(produit);
    }

    // Récupérer tous les produits
    public Iterable<Produit> getAllProduits() {
        if (produitRepository.count() == 0) {
            throw new NoProduitFoundException();
        }
        return produitRepository.findAll();
    }

    // Récupérer un produit par son ID
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException(id));
    }
}
