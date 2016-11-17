/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Employees;
import entity.Salaries;
import entity.SalariesPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author caoquan
 */
public class EmployeeDAO {
    public List<Employees> loadAllEmployees(){
        EntityManager em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        String hql = String.format("select a from %s a",Employees.class.getName());
        return em.createQuery(hql).setMaxResults(10).getResultList();
        
    }
    public List<Salaries> loadSalariesByEmpno(int empno){
        EntityManager em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        String hql = String.format("select a from %s a where a.employees.empNo = :empno",Salaries.class.getName());
        return em.createQuery(hql)
                .setParameter("empno", empno)
                .getResultList();
    }
    public Employees loadDetailEmployee(String empno){
        EntityManager em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        return em.find(Employees.class, empno);
    }
    
    public Salaries loadDetailSalary(SalariesPK key){
        EntityManager em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        return em.find(Salaries.class, key);
    }
    
    public void deleteSalary(SalariesPK key){
        EntityManager em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Salaries.class, key));
        em.getTransaction().commit();
    }
    
    public void updateSalary(Salaries s){
        EntityManager em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        Salaries salary = em.find(Salaries.class, s.getSalariesPK());
        em.getTransaction().begin();
        salary.setSalary(s.getSalary());
        em.getTransaction().commit();
    }
    
    public void updateEmployee(Employees e){
        EntityManager em = Persistence.createEntityManagerFactory("WebApplication1PU").createEntityManager();
        Employees employee = em.find(Employees.class, e.getEmpNo());
        em.getTransaction().begin();
        if (employee != null){
            employee.setFirstName(e.getFirstName());
            employee.setBirthDate(e.getBirthDate());
            employee.setGender(e.getGender());
            employee.setHireDate(e.getHireDate());
            employee.setLastName(e.getLastName());
            
        }
        em.getTransaction().commit();
    }
}
