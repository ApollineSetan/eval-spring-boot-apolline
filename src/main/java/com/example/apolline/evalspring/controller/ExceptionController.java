package com.example.apolline.evalspring.controller;

import com.example.apolline.evalspring.exception.NoProduitFoundException;
import com.example.apolline.evalspring.exception.ProduitAlreadyExistsException;
import com.example.apolline.evalspring.exception.ProduitNotFoundException;
import com.example.apolline.evalspring.exception.CategorieNotFoundException;
import com.example.apolline.evalspring.exception.CategorieAlreadyExistsException;
import com.example.apolline.evalspring.exception.NoCategorieFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    // Gérer l'exception ProduitNotFoundException
    @ExceptionHandler(ProduitNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProduitNotFound(ProduitNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    // Gérer l'exception NoProduitFoundException
    @ExceptionHandler(NoProduitFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoProduitFound(NoProduitFoundException ex) {
        return ex.getMessage();
    }

    // Gérer l'exception ProduitAlreadyExistsException
    @ExceptionHandler(ProduitAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleProduitAlreadyExists(ProduitAlreadyExistsException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    // Gérer l'exception CategorieNotFoundException
    @ExceptionHandler(CategorieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategorieNotFound(CategorieNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    // Gérer l'exception NoCategorieFoundException
    @ExceptionHandler(NoCategorieFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoCategorieFound(NoCategorieFoundException ex) {
        return ex.getMessage();
    }

    // Gérer l'exception CategorieAlreadyExistsException
    @ExceptionHandler(CategorieAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategorieAlreadyExists(CategorieAlreadyExistsException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    // Gérer les erreurs de validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
