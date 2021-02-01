package com.grondas.web.v1.model.google;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class GoogleMatrix {

    private List<String> destinationAddresses = null;
    private List<String> originAddresses = null;
    private List<Row> rows = null;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}