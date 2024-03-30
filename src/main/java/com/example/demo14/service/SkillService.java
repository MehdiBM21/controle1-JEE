package com.example.demo14.service;

import com.example.demo14.dao.impl.SkillDaoImpl;
import com.example.demo14.model.Skill;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class SkillService {
    private SkillDaoImpl skillDao;

    public SkillService(){
        this.skillDao = new SkillDaoImpl();
    }

    public List<Skill> findAll(){
        return skillDao.findAll();
    }
    public String findByEmployeId(Long id) {
        List<Skill> skills = skillDao.findByEmployeId(id);
        if(skills == null){
            return "no skills found.";
        }
        StringBuilder result = new StringBuilder();

        for (Skill skill : skills) {
            result.append(skill.getName()).append("\n");
        }

        // Remove the last newline character if there are skills
        if (result.length() > 0) {
            result.delete(result.length() - 1, result.length());
        }

        return result.toString();
    }



}
