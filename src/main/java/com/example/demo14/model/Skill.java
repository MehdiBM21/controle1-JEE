package com.example.demo14.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "employe")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String name;

//    @ManyToMany(mappedBy = "skills")
    @ManyToOne
    @JoinColumn(name="employe_id", nullable=false)
    private Employe employe;

    public Skill(String name) {
        this.name = name;
    }

//    public void addEmploye(Employe employe) {
//        boolean added = employes.add(employe);
//        if (added) {
//            employe.getSkills().add(this);
//        }
//    }
//
//    public void removeEmploye(Employe employe) {
//        boolean removed = employes.remove(employe);
//        if (removed) {
//            employe.getSkills().remove(this);
//        }
//    }

    public void addEmploye(Employe employe) {
        this.employe = employe;
        employe.getSkills().add(this);
    }

    public void removeEmploye(Employe employe) {
        this.employe = null;
        employe.getSkills().remove(this);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Skill{id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", employe=");
        if (employe != null) {
            sb.append(employe.getName());
        } else {
            sb.append("null");
        }
        sb.append("}");
        return sb.toString();
    }


}
