package com.example.demo14.dao.impl;


import com.example.demo14.model.Contribution;
import com.example.demo14.model.Employe;
import com.example.demo14.model.Skill;
import jakarta.persistence.*;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
@ManagedBean
public class EmployeDaoImpl {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public EmployeDaoImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("eclipse-link");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void addSkill(Skill skill, long id){

        entityManager.getTransaction().begin();
        Employe employe = entityManager.find(Employe.class, id);
        employe.getSkills().add(skill);
        entityManager.getTransaction().commit();
    }

    public void save(Employe employe) {
        entityManager.getTransaction().begin();
        entityManager.persist(employe);
        entityManager.getTransaction().commit();
    }

    public void update(Employe employe) {
        entityManager.getTransaction().begin();
        entityManager.merge(employe);
        entityManager.getTransaction().commit();
    }

    public void delete(Employe employe) {
        Employe e = entityManager.find(Employe.class, employe.getId());
        entityManager.getTransaction().begin();

        List<Skill> skillsCopy = new ArrayList<>(e.getSkills());
        List<Contribution> contributionsCopy = new ArrayList<>(e.getContributions());

        for (Skill s : skillsCopy) {
            e.removeSkill(s);
            entityManager.remove(s);
        }

        for (Contribution c : contributionsCopy) {
            e.removeContribution(c);
            entityManager.remove(c);
        }

        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }




    public Employe findById(Long id) {
        return entityManager.find(Employe.class, id);
    }

    public List<Employe> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employe e", Employe.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // Custom queries
    public Employe findByName(String name) {
        Query query = entityManager.createQuery("SELECT e FROM Employe e WHERE e.name = :name", Employe.class);
        query.setParameter("name", name);
        try {
            return (Employe) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Contribution> getContributionsByEmployeId(long id) {
        Query query = entityManager.createQuery("SELECT c FROM Contribution c WHERE c.employe.id = :id", Contribution.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
