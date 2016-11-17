/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author caoquan
 */
@Entity
@Table(name = "avg_salary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvgSalary.findAll", query = "SELECT a FROM AvgSalary a")
    , @NamedQuery(name = "AvgSalary.findByEmpNo", query = "SELECT a FROM AvgSalary a WHERE a.empNo = :empNo")
    , @NamedQuery(name = "AvgSalary.findByAverageSalary", query = "SELECT a FROM AvgSalary a WHERE a.averageSalary = :averageSalary")})
public class AvgSalary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "emp_no")
    @Id
    private int empNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "average_salary")
    private BigDecimal averageSalary;

    public AvgSalary() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }
    
}
