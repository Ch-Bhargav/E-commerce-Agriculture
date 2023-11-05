package com.example.sdp.service;

import com.example.sdp.entity.Product;
import com.example.sdp.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements productInterface {
    private EntityManager em;

    public ProductService(EntityManager em){
        this.em=em;
    }
    @Override
    @Transactional
    public String saveProduct(Product product) {
        em.persist(product);
        return null;
    }

    @Transactional
    public void updateProduct(Product updatedProduct) {
       em.merge(updatedProduct);
    }



    public List<Product> findByCategory(String category){
        TypedQuery<Product> query = em.createQuery("FROM Product WHERE category = :data", Product.class);
        query.setParameter("data", category);
     
        return  query.getResultList();
        
    }


    @Transactional
    public void delete(Product product){
        em.remove(product);
    }



    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = em.createQuery("FROM Product WHERE id =:data", Product.class);
        query.setParameter("data", id);
        return query.getSingleResult();

    }


}
