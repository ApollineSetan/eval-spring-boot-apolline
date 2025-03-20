package com.example.apolline.evalspring.repository;

import com.example.apolline.evalspring.model.Categorie;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    boolean existsByLibelle(String libelle);
}
