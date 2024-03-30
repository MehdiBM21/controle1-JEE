package com.example.demo14.dao.impl;


import com.example.demo14.model.Contribution;
import com.example.demo14.model.Project;
import jakarta.persistence.*;

import java.util.List;

public class ProjectDaoImpl {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public ProjectDaoImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("eclipse-link");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
    }

    public void update(Project project) {
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
    }

    public void delete(Project project) {
        Project p = entityManager.find(Project.class, project.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();
    }

    public Project findById(Long id) {
        return entityManager.find(Project.class, id);
    }

    public List<Project> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Project p", Project.class);
        return query.getResultList();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // Custom queries
    public Project findByName(String name) {
        Query query = entityManager.createQuery("SELECT p FROM Project p WHERE p.name = :name", Project.class);
        query.setParameter("name", name);
        try {
            return (Project) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public List<Contribution> findContributionsByProjectId(long id){
        Query query = entityManager.createQuery("SELECT c FROM Contribution c WHERE c.project.id = :project", Contribution.class);
        query.setParameter("project", id);
        return query.getResultList();
    }
}
