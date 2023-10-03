package com.senacead.biblioteca.model.repository;

import com.senacead.biblioteca.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
    
}
