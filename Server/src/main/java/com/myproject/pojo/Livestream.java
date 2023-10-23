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
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Thanh
 */
@Entity
@Table(name = "livestream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livestream.findAll", query = "SELECT l FROM Livestream l"),
    @NamedQuery(name = "Livestream.findById", query = "SELECT l FROM Livestream l WHERE l.id = :id"),
    @NamedQuery(name = "Livestream.findByTitle", query = "SELECT l FROM Livestream l WHERE l.title = :title"),
    @NamedQuery(name = "Livestream.findByContent", query = "SELECT l FROM Livestream l WHERE l.content = :content")})
public class Livestream implements Serializable {

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "title")
    private String title;
    @Size(max = 500)
    @Column(name = "content")
    private String content;
    @OneToMany(mappedBy = "livestreamId")
    @JsonIgnore
    private Set<Question> questionSet;

    public Livestream() {
    }

    public Livestream(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    @XmlTransient
//    @JsonIgnore
//    public Set<Question> getQuestionSet() {
//        return questionSet;
//    }
//
//    public void setQuestionSet(Set<Question> questionSet) {
//        this.questionSet = questionSet;
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
        if (!(object instanceof Livestream)) {
            return false;
        }
        Livestream other = (Livestream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myproject.pojo.Livestream[ id=" + id + " ]";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
