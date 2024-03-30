package com.example.demo14.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean
@EqualsAndHashCode(exclude = {"project", "employe"})
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String implication;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

    public void addEmploye(Employe employe){
        this.employe = employe;
        employe.getContributions().add(this);
    }

    public void addProject(Project project){
        this.project = project;
        project.getContributions().add(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Contribution{id=").append(id);
        sb.append(", implication='").append(implication).append('\'');
        sb.append(", employe=").append(employe.getName());
        sb.append(", project=").append(project.getName());
        sb.append("}");
        return sb.toString();
    }




}
