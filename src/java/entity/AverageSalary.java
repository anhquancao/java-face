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
@Table(name = "average_salary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AverageSalary.findAll", query = "SELECT a FROM AverageSalary a")
    , @NamedQuery(name = "AverageSalary.findByEmpNo", query = "SELECT a FROM AverageSalary a WHERE a.empNo = :empNo")
    , @NamedQuery(name = "AverageSalary.findByAverageSalary", query = "SELECT a FROM AverageSalary a WHERE a.averageSalary = :averageSalary")})
public class AverageSalary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "emp_no")
    @Id
    private int empNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "average_salary")
    private BigDecimal averageSalary;

    public AverageSalary() {
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
