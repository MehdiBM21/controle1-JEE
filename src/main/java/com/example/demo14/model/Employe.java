package com.example.demo14.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean
@EqualsAndHashCode(exclude = {"skills", "contributions"})

public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;
    private String email;

    public Employe(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "employe_skill",
//            joinColumns = @JoinColumn(name = "employe_id"),
//            inverseJoinColumns = @JoinColumn(name = "skill_id"),
//            uniqueConstraints = {
//                    @UniqueConstraint(columnNames ={"employe_id", "skill_id"})
//            })
    @OneToMany(mappedBy = "employe", cascade = CascadeType.PERSIST)
    private Set<Skill> skills=new HashSet<>();

    @OneToMany(mappedBy ="employe", cascade = CascadeType.REMOVE)
    private Set<Contribution> contributions=new HashSet<>();

    public void addContribution(Contribution contribution){
        contributions.add(contribution);
        contribution.setEmploye(this);
    }
//    public void removeContribution(Contribution contribution){
//        contributions.remove(contribution);
//        contribution.setEmploye(null);
//    }


//    public void addSkill(Skill skill) {
//        boolean added = skills.add(skill);
//        if (added) {
//            skill.getEmployes().add(this);
//        }
//    }
//
//    public void removeSkill(Skill skill) {
//        boolean removed = skills.remove(skill);
//        if (removed) {
//            skill.getEmployes().remove(this);
//        }
//    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
        skill.setEmploye(this);
    }

    public void removeSkill(Skill skill) {
        this.skills.remove(skill);
//        skill.setEmploye(null);
    }

    @Override
    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Employe{id=").append(id);
//        sb.append(", name='").append(name).append('\'');
//        sb.append(", email='").append(email).append('\'');
//        sb.append(", skills=[");
//        for (Skill skill : skills) {
//            sb.append(skill.getName()).append(", ");
//        }
//        if (!skills.isEmpty()) {
//            sb.delete(sb.length() - 2, sb.length());
//        }
//        sb.append("]}");
//        return sb.toString();
        return "Employe[id=" + id + "]";
    }


    public void removeContribution(Contribution c) {
        contributions.remove(c);
        c.setEmploye(null);
    }
}
