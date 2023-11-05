package com.example.sdp.service;

import com.example.sdp.entity.Farmer;
import com.example.sdp.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements userInterface{

    private EntityManager em;

    public UserService(EntityManager em){
        this.em=em;
    }
    @Override
    public Users findByUsername(String username, String password) {
        TypedQuery<Users> query = em.createQuery("FROM Users WHERE username = :data AND password = :pass", Users.class);
        query.setParameter("data", username);
        query.setParameter("pass", password);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // User not found
        }
    }

    @Override
    public Users findByUsername(String username) {
        TypedQuery<Users> query = em.createQuery("FROM Users WHERE username = :data", Users.class);
        query.setParameter("data", username);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // User not found
        }
    }


    @Override
    @Transactional
    public Object save(Users users) {
        em.persist(users);
        return null;
    }

    @Override
    public List<Users> getAllUsers() {
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u", Users.class);
        return query.getResultList();
    }
	@Override
	public Object save(Farmer users) {
		// TODO Auto-generated method stub
		return null;
	}



}
