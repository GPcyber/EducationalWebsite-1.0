package com.example.eventplanner.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="enquiryTable")
public class enquirySubmit {


    Long courseID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long eid;
    String name;
    String qualification;
    Long mobilephone;
    String email;

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Long getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(Long mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public enquirySubmit()
 {

 }

    public enquirySubmit(Long courseID, String name, Long mobilephone, String email) {
        this.courseID = courseID;
        this.name = name;
        this.mobilephone = mobilephone;
        this.email = email;
    }

    public enquirySubmit(Long courseID, Long eid, String name, String qualification, Long mobilephone, String email) {
        this.courseID = courseID;
        this.eid = eid;
        this.name = name;
        this.qualification = qualification;
        this.mobilephone = mobilephone;
        this.email = email;
    }
}
