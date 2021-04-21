package com.firsov.finhelper.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesTable extends JpaRepository<Rate, Integer> {
    Rate findByCode(String code);
    Rate findFirstByCodeOrderByIdDesc(String code);
}
