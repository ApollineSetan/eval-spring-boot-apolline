package com.example.apolline.evalspring.exception;

public class CategorieNotFoundException extends RuntimeException{
    public CategorieNotFoundException(Long id) {
        super("La catégorie avec l'id " + id + " n'existe pas.");
    }
}
