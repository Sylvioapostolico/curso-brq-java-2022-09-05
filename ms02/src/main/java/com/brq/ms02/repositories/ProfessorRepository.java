package com.brq.ms02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<com.brq.ms02.models.ProfessorModel, Integer> {
}
