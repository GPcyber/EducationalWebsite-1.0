package com.example.eventplanner.model;

import org.springframework.web.bind.annotation.ModelAttribute;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="enquiryTable")
public class enquirySubmit {


    Long courseID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long eid;

    String ename;
    String qualification;
    Integer mobilephone;
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

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(Integer mobilephone) {
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

    public enquirySubmit(Long courseID, Long eid, String ename, String qualification, Integer mobilephone, String email) {
        this.courseID = courseID;
        this.eid = eid;
        this.ename = ename;
        this.qualification = qualification;
        this.mobilephone = mobilephone;
        this.email = email;
    }
}
