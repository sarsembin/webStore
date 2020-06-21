package com.store.webStore.repos;

import com.store.webStore.entity.Product;
import com.store.webStore.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName (String name);
    Product findById (long id);
    List<Product> findAll();
    List<Product> findAllByProductType(ProductType productType);
}
