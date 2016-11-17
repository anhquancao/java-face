/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmployeeDAO;
import entity.Employees;
import entity.Salaries;
import entity.SalariesPK;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author caoquan
 */
@ManagedBean
@SessionScoped
public class EmployeeBean {

    private List<Employees> employees;
    private EmployeeDAO employeeDAO;
    private List<Salaries> salaries;
    private Salaries salary;
    /**
     * Creates a new instance of EmployeeBean
     */
    public EmployeeBean() {
        employeeDAO = new EmployeeDAO();
        employees = employeeDAO.loadAllEmployees();
    }
    
    public void loadSalariesByEmployee(int empno){
        this.salaries = employeeDAO.loadSalariesByEmpno(empno);
    }

    public void deleteSalary(int empNo, Date fromDate){
        SalariesPK key = new SalariesPK(empNo, fromDate);
        employeeDAO.deleteSalary(key);
        salaries = employeeDAO.loadSalariesByEmpno(key.getEmpNo());
    }
    
    public String updateSalary(){
        employeeDAO.updateSalary(this.salary);
        salaries = employeeDAO.loadSalariesByEmpno(this.salary.getSalariesPK().getEmpNo());
        return "index";
    }
    
    public String goBack(){
        this.employees = employeeDAO.loadAllEmployees();
        return "index";
    }
    
    public String addNewSalary(){
        this.salary = new Salaries();
        return "new";
    }
    
    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public List<Salaries> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salaries> salaries) {
        this.salaries = salaries;
    }

    public Salaries getSalary() {
        return salary;
    }

    public void setSalary(Salaries salary) {
        this.salary = salary;
    }
    
    public String loadDetailSalary(Date fromDate,int empNo){
        this.salary = employeeDAO.loadDetailSalary(new SalariesPK(empNo, fromDate));
        return "edit";
    }
    
}
