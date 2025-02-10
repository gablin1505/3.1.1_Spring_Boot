package com.example.myfirstspringboot4.daos;

import com.example.myfirstspringboot4.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao implements UserDaoInterface {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> index() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        User p = entityManager.find(User.class, id);
        if (p != null) {
            p.setName(user.getName());
            p.setAge(user.getAge());
            entityManager.merge(p);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        User p = entityManager.find(User.class, id);
        if (p != null) {
            entityManager.remove(p);
        }
    }

}
