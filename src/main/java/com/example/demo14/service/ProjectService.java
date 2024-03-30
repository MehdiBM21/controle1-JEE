package com.example.demo14.service;

import com.example.demo14.dao.impl.ProjectDaoImpl;
import com.example.demo14.model.Project;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@Data
@ManagedBean
@RequestScoped
public class ProjectService {
    private ProjectDaoImpl projectDao;
    public ProjectService(){
        projectDao = new ProjectDaoImpl();
    }
    public List<Project> findAll(){
        return projectDao.findAll();
    }

    public Project findById(long l) {
        return projectDao.findById(l);
    }
}
