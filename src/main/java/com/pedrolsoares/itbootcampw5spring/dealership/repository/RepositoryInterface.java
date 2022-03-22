package com.pedrolsoares.itbootcampw5spring.dealership.repository;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<T, K> {

    public List<T> findAll();

    public Optional<T> findByKey(K key);

    public K insertOne(T data);

    public boolean update(K id, T data);

    public boolean delete(K id);
}
