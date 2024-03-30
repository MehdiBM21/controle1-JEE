package com.example.demo14.dao;

import com.example.demo14.dao.impl.ContributionDaoImpl;
import com.example.demo14.dao.impl.EmployeDaoImpl;
import com.example.demo14.dao.impl.ProjectDaoImpl;
import com.example.demo14.dao.impl.SkillDaoImpl;
import com.example.demo14.model.Contribution;
import com.example.demo14.model.Employe;
import com.example.demo14.model.Project;
import com.example.demo14.model.Skill;
import com.example.demo14.service.EmployeService;


public class MainDb {
    public static void main(String[] args) {
        EmployeDaoImpl employeDao = new EmployeDaoImpl();

        SkillDaoImpl skillDao = new SkillDaoImpl();
        System.out.println("skills for id=1: "+ skillDao.findByEmployeId(1L));

        Employe e = new Employe();
        e.setName("testt");
        e.setEmail("test@example.com");
        Skill skill = new Skill();
        skill.setName("java");
        Skill skill1 = new Skill();
        skill1.setName("spring");
        e.addSkill(skill1);
        e.addSkill(skill);
//        employeDao.save(e);
        System.out.println("added employe: " + e);
        System.out.println(e);
//        employeDao.delete(e);

        ContributionDaoImpl contributionDao = new ContributionDaoImpl();
        System.out.println("all employees: " + employeDao.findAll());
//      e= employeDao.findById(1L);
//
//        Project project = new Project();
//        project.setName("testProjet");
//        project.setBudget(1000.0);

        ProjectDaoImpl projectDao = new ProjectDaoImpl();
//        projectDao.save(project);
        Project project1 = new Project();
        project1.setName("Projet A");
        project1.setBudget(1000.0);
        projectDao.save(project1);

        Project project2 = new Project();
        project2.setName("Projet B");
        project2.setBudget(1000.0);
        projectDao.save(project2);

//TODO:: drop-and-create-tables

//
        Contribution c = new Contribution();
//        c.addProject(project);
//        c.addEmploye(e);
//        c.setImplication("100%");
//        contributionDao.save(c);
//        System.out.println(contributionDao.findAll());
//
//        System.out.println(employeDao.findAll());
//
//        Project projectToAdd = projectDao.findById(project.getId());
//        Employe employeToAdd = employeDao.findById(e.getId());
//        System.out.println("skills " + e.getSkills());
//        Contribution ct = new Contribution();
//        c.addProject(projectToAdd);
//        c.addEmploye(employeToAdd);
//        c.setImplication("100%");
//        contributionDao.save(ct);
//        System.out.println("Added contribution: " + c);
//        EmployeService employeService = new EmployeService();
//        employeService.delete(e);
//        System.out.println("employe deleted!");

    }
}