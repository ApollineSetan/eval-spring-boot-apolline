package com.example.apolline.evalspring.exception;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(Long id) {
        super("Le produit avec l'id " + id + " n'existe pas");
    }
}
