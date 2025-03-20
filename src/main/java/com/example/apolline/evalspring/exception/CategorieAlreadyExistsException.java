package com.example.apolline.evalspring.exception;

import com.example.apolline.evalspring.model.Categorie;

public class CategorieAlreadyExistsException extends RuntimeException {
    public CategorieAlreadyExistsException(Categorie categorie) {
        super("La catégorie " + categorie.getLibelle() + " existe déjà.");
    }
}
