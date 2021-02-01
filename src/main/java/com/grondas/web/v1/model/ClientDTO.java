package com.grondas.web.v1.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO extends BaseDTO {

    private String clientName;
    private String clientUrl;

//    private List<TransferDTO> transfers = new ArrayList<>();

    @Override
    public String toString() {
        return clientName;
    }
}
