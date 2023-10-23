/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thanh
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findById", query = "SELECT d FROM Department d WHERE d.id = :id"),
    @NamedQuery(name = "Department.findByDescription", query = "SELECT d FROM Department d WHERE d.description = :description"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findByEducationProgram", query = "SELECT d FROM Department d WHERE d.educationProgram = :educationProgram"),
    @NamedQuery(name = "Department.findByWebsite", query = "SELECT d FROM Department d WHERE d.website = :website"),
    @NamedQuery(name = "Department.findByIntroduceVideo", query = "SELECT d FROM Department d WHERE d.introduceVideo = :introduceVideo"),
    @NamedQuery(name = "Department.findByAverageScore", query = "SELECT d FROM Department d WHERE d.averageScore = :averageScore")})
public class Department implements Serializable {

    @Size(max = 200)
    @Column(name = "image")
    private String image;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "average_score")
    private String averageScore;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 1500)
    @Column(name = "description")
    private String description;
    @Size(max = 1000)
    @Column(name = "name")
    private String name;
    @Size(max = 10000)
    @Column(name = "education_program")
    private String educationProgram;
    @Size(max = 45)
    @Column(name = "website")
    private String website;
    @Size(max = 100)
    @Column(name = "introduce_video")
    private String introduceVideo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @JoinColumn(name = "typeoftrainning_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Typeoftrainning typeoftrainningId;
    
    @Transient
    private MultipartFile file;

    public Department() {
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducationProgram() {
        return educationProgram;
    }

    public void setEducationProgram(String educationProgram) {
        this.educationProgram = educationProgram;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIntroduceVideo() {
        return introduceVideo;
    }

    public void setIntroduceVideo(String introduceVideo) {
        this.introduceVideo = introduceVideo;
    }

    public Typeoftrainning getTypeoftrainningId() {
        return typeoftrainningId;
    }

    public void setTypeoftrainningId(Typeoftrainning typeoftrainningId) {
        this.typeoftrainningId = typeoftrainningId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myproject.pojo.Department[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
