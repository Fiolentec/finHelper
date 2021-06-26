package com.firsov.finhelper.dao;

import com.firsov.finhelper.service.ActualDividendContainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DividendContainerDTO {
    String message;
    Set<ActualDividendContainer> dividends;
}
