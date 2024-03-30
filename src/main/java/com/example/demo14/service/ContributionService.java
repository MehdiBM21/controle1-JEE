package com.example.demo14.service;

import com.example.demo14.dao.impl.ContributionDaoImpl;
import com.example.demo14.model.Contribution;
import com.example.demo14.model.Project;
import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
@ManagedBean
@RequestScoped
@Data
public class ContributionService {
    private ContributionDaoImpl contributionDao;

    public ContributionService() {
        this.contributionDao = new ContributionDaoImpl();
    }

    public List<Contribution> findAll() {
        return contributionDao.findAll();
    }

    public void save(Contribution c) {
        contributionDao.save(c);
    }

//1- fetch the contributions from employe id
    //2- fetch the projects of those contributions
    //3- concatenate project + implication
public String showProjectsAndImplication(long id) {
    StringBuilder sb = new StringBuilder();
    List<Contribution> contributions = contributionDao.findContributionsByEmployeId(id);
    if(contributions == null){
        return "no contributions found.";
    }

    for (Contribution contribution : contributions) {
        Project project = contributionDao.getProjectByContributionId(contribution.getId());
        sb.append(project.getName()).append(" (").append(contribution.getImplication()).append(")\n");
    }

    // Remove the last newline character if there are contributions
    if (sb.length() > 0) {
        sb.delete(sb.length() - 1, sb.length());
    }

    return sb.toString();
}


}