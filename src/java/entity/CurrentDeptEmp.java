/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author caoquan
 */
@Entity
@Table(name = "current_dept_emp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CurrentDeptEmp.findAll", query = "SELECT c FROM CurrentDeptEmp c")
    , @NamedQuery(name = "CurrentDeptEmp.findByEmpNo", query = "SELECT c FROM CurrentDeptEmp c WHERE c.empNo = :empNo")
    , @NamedQuery(name = "CurrentDeptEmp.findByDeptNo", query = "SELECT c FROM CurrentDeptEmp c WHERE c.deptNo = :deptNo")
    , @NamedQuery(name = "CurrentDeptEmp.findByFromDate", query = "SELECT c FROM CurrentDeptEmp c WHERE c.fromDate = :fromDate")
    , @NamedQuery(name = "CurrentDeptEmp.findByToDate", query = "SELECT c FROM CurrentDeptEmp c WHERE c.toDate = :toDate")})
public class CurrentDeptEmp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "emp_no")
    private int empNo;
    @Basic(optional = false)
    @Column(name = "dept_no")
    private String deptNo;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Id
    private Long id;

    public CurrentDeptEmp() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
