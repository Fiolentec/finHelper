package com.firsov.finhelper.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "definitions")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class Definition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String term;
    String definition;

    public Definition() {
    }

    public Definition(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }
}
