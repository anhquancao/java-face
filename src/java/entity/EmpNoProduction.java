/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "emp_no_production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpNoProduction.findAll", query = "SELECT e FROM EmpNoProduction e")
    , @NamedQuery(name = "EmpNoProduction.findByEmpNo", query = "SELECT e FROM EmpNoProduction e WHERE e.empNo = :empNo")})
public class EmpNoProduction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "emp_no")
    @Id
    private int empNo;

    public EmpNoProduction() {
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
    
}
