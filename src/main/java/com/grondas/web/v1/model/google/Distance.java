package com.grondas.web.v1.model.google;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Distance {

    private String text;
    private Integer value;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}