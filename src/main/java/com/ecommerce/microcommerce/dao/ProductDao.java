package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    //public List<Product> findAll();
    //public Product save(Product product);

    Product findById(int id);
    List<Product> findByPrixGreaterThan(int prixLimit);
    List<Product> findByNomLike(String recherche);
    List<Product> findByOrderByNomAsc();

    @Query("SELECT p FROM Product p WHERE p.prix > :prixLimit")
    List<Product> chercherProduitPlusCher(@Param("prixLimit")int prixLimit);
}