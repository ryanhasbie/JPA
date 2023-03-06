package com.enigma.repository;


import java.util.List;

public interface IRepo<T> {
    void create (T params);
    List<T> findAll(Integer page, Integer size);
    void update(T params);
    T findOne(String id);
    List<T> findByName(String name);
    void delete(String id);
}
