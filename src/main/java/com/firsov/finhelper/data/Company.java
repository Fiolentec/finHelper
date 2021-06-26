package com.firsov.finhelper.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "companies")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String identifier;
    private Double dividendRate;
    private Double dividendYield;
    private LocalDate exDividendDate;

    public boolean isActual() {
        return isActual(LocalDate.now());
    }

    public boolean isActual(LocalDate date) {
        long days = getDays(date);
        return days <= 7 && days >= 0;
    }

    public long getDays() {
        return getDays(LocalDate.now());
    }

    public long getDays(LocalDate date) {
        return DAYS.between(date, exDividendDate);
    }

}
