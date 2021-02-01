package com.grondas.services.v1;

import java.util.List;

public interface BaseService<T, ID> {

    List<T> findAll();

    T findDtoById(ID id);

    T createNewObject(T objectDTO);

    void delete(T objectDTO);

    void deleteById(ID id);
}
