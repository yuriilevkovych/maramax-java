package com.maramax.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findByTypeOrderById(String type);
    List<Product> findAllByOrderByIdDesc();
}
