package com.pfa.repository;

import com.pfa.model.Audit;
import com.pfa.model.Clause;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClauseRepository extends JpaRepository<Clause, Integer> {
    List<Clause> findByAudit(Audit audit);
}
