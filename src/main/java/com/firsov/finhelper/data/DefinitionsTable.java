package com.firsov.finhelper.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinitionsTable extends JpaRepository<Definition, Integer> {
    Definition findByTerm(String term);
}
