package com.example.demo14.dao.impl;

import com.example.demo14.model.Skill;
import jakarta.persistence.*;

import java.util.List;

public class SkillDaoImpl {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public SkillDaoImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("eclipse-link");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Skill skill) {
        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();
    }

    public void update(Skill skill) {
        entityManager.getTransaction().begin();
        entityManager.merge(skill);
        entityManager.getTransaction().commit();
    }

    public void delete(Skill skill) {
        Skill s = entityManager.find(Skill.class, skill.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(s);
        entityManager.getTransaction().commit();
    }

    public Skill findById(Long id) {
        return entityManager.find(Skill.class, id);
    }

    public List<Skill> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Skill s", Skill.class);
        return query.getResultList();
    }
    public List<Skill> findByEmployeId(Long employeeId) {
        Query query = entityManager.createQuery("SELECT s FROM Skill s WHERE s.employe.id = :employeeId", Skill.class);
        query.setParameter("employeeId", employeeId);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // Custom queries
    public Skill findByName(String name) {
        Query query = entityManager.createQuery("SELECT s FROM Skill s WHERE s.name = :name", Skill.class);
        query.setParameter("name", name);
        try {
            return (Skill) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
