package com.pfa.repository;

import com.pfa.model.Action;
import com.pfa.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    List<Action> findByAudit(Audit audit);
}
