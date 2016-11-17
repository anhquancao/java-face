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
@Table(name = "dept_emp_latest_date")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeptEmpLatestDate.findAll", query = "SELECT d FROM DeptEmpLatestDate d")
    , @NamedQuery(name = "DeptEmpLatestDate.findByEmpNo", query = "SELECT d FROM DeptEmpLatestDate d WHERE d.empNo = :empNo")
    , @NamedQuery(name = "DeptEmpLatestDate.findByFromDate", query = "SELECT d FROM DeptEmpLatestDate d WHERE d.fromDate = :fromDate")
    , @NamedQuery(name = "DeptEmpLatestDate.findByToDate", query = "SELECT d FROM DeptEmpLatestDate d WHERE d.toDate = :toDate")})
public class DeptEmpLatestDate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "emp_no")
    @Id
    private int empNo;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    public DeptEmpLatestDate() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
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
    
}
