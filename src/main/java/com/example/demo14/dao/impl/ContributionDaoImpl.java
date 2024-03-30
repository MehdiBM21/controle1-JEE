package com.example.demo14.dao.impl;


import com.example.demo14.model.Contribution;
import com.example.demo14.model.Employe;
import com.example.demo14.model.Project;
import jakarta.persistence.*;

import java.util.List;

public class ContributionDaoImpl {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public ContributionDaoImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("eclipse-link");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Contribution contribution) {
        entityManager.getTransaction().begin();
        entityManager.persist(contribution);
        entityManager.getTransaction().commit();
    }

    public void update(Contribution contribution) {
        entityManager.getTransaction().begin();
        entityManager.merge(contribution);
        entityManager.getTransaction().commit();
    }

    public void delete(Contribution contribution) {
        Contribution c = entityManager.find(Contribution.class, contribution.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(c);
        entityManager.getTransaction().commit();
    }

    public Contribution findById(Long id) {
        return entityManager.find(Contribution.class, id);
    }

    public List<Contribution> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Contribution c", Contribution.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // Custom queries
    public Contribution findByImplication(String implication) {
        Query query = entityManager.createQuery("SELECT c FROM Contribution c WHERE c.implication = :implication", Contribution.class);
        query.setParameter("implication", implication);
        try {
            return (Contribution) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public List<Contribution> findContributionsByEmployeId(Long id) {
        Query query = entityManager.createQuery("SELECT c FROM Contribution c WHERE c.employe.id = :employe", Contribution.class);
        query.setParameter("employe", id);
        return query.getResultList();
    }
    public Project getProjectByContributionId(Long id) {
        Query query = entityManager.createQuery("SELECT c.project FROM Contribution c WHERE c.id = :id", Project.class);
        query.setParameter("id", id);
        return (Project) query.getSingleResult();
    }

}
