package com.example.apolline.evalspring.repository;

import com.example.apolline.evalspring.model.Produit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
    boolean existsByNom(String nom);
}
