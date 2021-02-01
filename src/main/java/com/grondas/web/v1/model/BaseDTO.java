package com.grondas.web.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public abstract class BaseDTO {

    private Long id;
//    private long version;

    @JsonFormat(pattern="dd-MM-yyyy' 'HH:mm", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime createdAt;
    @JsonFormat(pattern="dd-MM-yyyy' 'HH:mm:ss:nn", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime updatedAt;

}
