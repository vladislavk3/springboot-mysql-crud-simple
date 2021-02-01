package com.grondas.web.v1.model.google;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class Row {

    private List<Element> elements = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}