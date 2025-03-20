package com.example.apolline.evalspring.exception;
import com.example.apolline.evalspring.model.Produit;

public class ProduitAlreadyExistsException extends RuntimeException{
    public ProduitAlreadyExistsException(Produit produit) {
        super("Le produit " + produit.getNom() + " existe déjà.");
    }
}
