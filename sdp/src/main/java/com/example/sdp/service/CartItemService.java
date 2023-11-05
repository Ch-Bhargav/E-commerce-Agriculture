package com.example.sdp.service;

import com.example.sdp.entity.CartItem;
import com.example.sdp.entity.Order;

//import com.example.sdp.payment.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    EntityManager em;

    @Transactional
    public void save(CartItem cartItem){
        em.persist(cartItem);
    }

    public List<CartItem> getUserProducts(int id){
        TypedQuery<CartItem> query=em.createQuery("From CartItem where userId=:data",CartItem.class);
        query.setParameter("data",id);
        return query.getResultList();
    }
    public CartItem findById(int id){
        TypedQuery<CartItem> query=em.createQuery("From CartItem where id=:data",CartItem.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }


    @Transactional
    public void saveOrder(Order order){
        em.merge(order);
    }
    @Transactional
    public void removeFromCart(CartItem cartItem){

        em.remove(cartItem);
    }
}