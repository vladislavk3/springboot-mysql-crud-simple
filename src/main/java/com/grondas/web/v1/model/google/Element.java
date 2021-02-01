package com.grondas.web.v1.model.google;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Element {

    private Distance distance;
    private Duration duration;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}