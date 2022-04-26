package com.epam.esm.service.base;

import java.util.List;
import java.util.Optional;

public interface BaseService <T,ID>{
     List<T> getAll();
     Optional<T> getById(ID key);
     T save(T value);
     boolean delete(ID key);
}
