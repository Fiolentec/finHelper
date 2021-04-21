package com.firsov.finhelper.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseContainer {
    String response;

    public ResponseContainer(String response) {
        this.response = response;
    }
}
