package com.firsov.finhelper.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "rates")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Cacheable
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @JsonProperty("CharCode")
    String code;
    @JsonProperty("Nominal")
    Integer nominal;
    @JsonProperty("Name")
    String description;
    @JsonProperty("Value")
    String ratevalue;

}
