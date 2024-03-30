package com.example.demo14.bean;

import com.example.demo14.model.Employe;
import com.example.demo14.model.Skill;
import com.example.demo14.service.EmployeService;
import lombok.Data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.List;

@Data
@ManagedBean
@ApplicationScoped
public class TableEmpBean {
    private EmployeService employeService;
    private String skills;
    private boolean form;

    public TableEmpBean() {
        this.employeService = new EmployeService();
    }
    public List<Employe> getAllEmploye(){
        return employeService.findAll();
    }
    public void switchForm(){
        this.form = !this.form;
    }

    public void save(Employe employee){
        String[] allSkills = skills.split("-");
        for(String skill : allSkills){
            employee.addSkill(new Skill(skill));
        }
        employeService.save(employee);
        System.out.println("employee Successfully created");
        skills="";
    }
}
