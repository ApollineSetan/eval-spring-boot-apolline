package com.example.apolline.evalspring.exception;

public class NoProduitFoundException extends RuntimeException {
    public NoProduitFoundException() {
        super("Aucun produit n'est présent pour le moment.");
    }
}
