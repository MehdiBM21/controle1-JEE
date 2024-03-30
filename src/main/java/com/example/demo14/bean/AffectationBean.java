package com.example.demo14.bean;

import com.example.demo14.dao.impl.ContributionDaoImpl;
import com.example.demo14.model.Contribution;
import com.example.demo14.model.Employe;
import com.example.demo14.model.Project;
import com.example.demo14.service.ContributionService;
import com.example.demo14.service.EmployeService;
import com.example.demo14.service.ProjectService;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@ManagedBean
@ViewScoped
public class AffectationBean {
    private Project project;
    private Employe employe;
    private String contributionPercent;
    private List<Project> projects;
    private List<Employe> employes;
    private ProjectService projectService;
    private EmployeService employeService;
    private ContributionService contributionService;

    public AffectationBean(){
        projects = new ProjectService().findAll();
        employes = new EmployeService().findAll();
        this.projectService = new ProjectService();
        this.employeService = new EmployeService();
        this.contributionService = new ContributionService();
    }
    public String affecter(){
//        System.out.println(project);
//        System.out.println(employe);
//        System.out.println(contributionPercent);

        Project projectToAdd = projectService.findById(project.getId());
        Employe employeToAdd = employeService.findById(employe.getId());
        Contribution c = new Contribution();
        c.addProject(projectToAdd);
        c.addEmploye(employeToAdd);
        c.setImplication(contributionPercent);
        contributionService.save(c);
        System.out.println("Added contribution: " + c);

        return "TableEmploye";
    }
    public void submit(){
        System.out.println("submit called");
    }
}
