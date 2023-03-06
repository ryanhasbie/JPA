package com.enigma.service;

public interface IService<T> {
    public void insert(T params);
    public void delete(String id);
    public void update(T params);
    public T getById(String id);
    public void getAll(Integer page, Integer size);
    public void getAllByName(String name);
}
