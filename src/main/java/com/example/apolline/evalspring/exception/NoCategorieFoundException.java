package com.example.apolline.evalspring.exception;

public class NoCategorieFoundException extends RuntimeException {
    public NoCategorieFoundException() {
        super("Aucune catégorie n'a été trouvée.");
    }
}