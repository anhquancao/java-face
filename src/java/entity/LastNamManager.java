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
@Table(name = "last_nam_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LastNamManager.findAll", query = "SELECT l FROM LastNamManager l")
    , @NamedQuery(name = "LastNamManager.findByLastName", query = "SELECT l FROM LastNamManager l WHERE l.lastName = :lastName")})
public class LastNamManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Id
    private Long id;

    public LastNamManager() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
