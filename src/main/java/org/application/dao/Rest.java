package org.application.dao;

import java.util.List;

public interface Rest<T> {

    List<T> findAll();

    T findById(Integer id);

    T create(T body);

    T update(Integer id, T body);

    void deleteById(Integer id);

}
