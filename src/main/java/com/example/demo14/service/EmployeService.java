package com.example.demo14.service;

import com.example.demo14.dao.impl.EmployeDaoImpl;
import com.example.demo14.model.Contribution;
import com.example.demo14.model.Employe;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@Data
@ManagedBean
@RequestScoped
public class EmployeService {
    private EmployeDaoImpl employeDao;
    public EmployeService(){
        employeDao = new EmployeDaoImpl();
    }

    public void save(Employe e){
        employeDao.save(e);
    }

    public void update(Employe e){
        employeDao.update(e);
    }

    public void delete(Employe e){


        employeDao.delete(e);
    }

    public Employe findById(Long id){
        return employeDao.findById(id);
    }

    public List<Employe> findAll(){
        return employeDao.findAll();
    }

}
