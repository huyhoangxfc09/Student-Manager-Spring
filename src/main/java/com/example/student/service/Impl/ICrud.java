package com.example.student.service.Impl;

import java.util.List;

public interface ICrud <E>{
    List<E> findAll();
    void save(E e);
    void update(int id, E e);
    void delete (E e);
    E findById(int id);
}
