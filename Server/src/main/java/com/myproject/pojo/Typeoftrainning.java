/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Thanh
 */
@Entity
@Table(name = "typeoftrainning")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeoftrainning.findAll", query = "SELECT t FROM Typeoftrainning t"),
    @NamedQuery(name = "Typeoftrainning.findById", query = "SELECT t FROM Typeoftrainning t WHERE t.id = :id"),
    @NamedQuery(name = "Typeoftrainning.findByName", query = "SELECT t FROM Typeoftrainning t WHERE t.name = :name")})
public class Typeoftrainning implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "typeoftrainningId")
    private Set<Post> postSet;
    @JsonIgnore
    @OneToMany(mappedBy = "typeoftrainningId")
    private Set<Department> departmentSet;

    public Typeoftrainning() {
    }

    public Typeoftrainning(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @XmlTransient
//    @JsonIgnore
//    public Set<Post> getPostSet() {
//        return postSet;
//    }
//
//    public void setPostSet(Set<Post> postSet) {
//        this.postSet = postSet;
//    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeoftrainning)) {
            return false;
        }
        Typeoftrainning other = (Typeoftrainning) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myproject.pojo.Typeoftrainning[ id=" + id + " ]";
    }
    
}
