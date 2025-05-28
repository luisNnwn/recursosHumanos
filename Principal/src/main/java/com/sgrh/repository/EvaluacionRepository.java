package com.sgrh.repository;

import com.sgrh.model.EvaluacionDesempeno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository extends JpaRepository<EvaluacionDesempeno, Integer> {
}
