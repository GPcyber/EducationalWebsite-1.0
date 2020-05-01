package com.example.eventplanner.model;

import org.hibernate.annotations.common.reflection.XMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user" )
public class User  {

    Long uid;
    String uname;
    String umobilenumber;
    @Id
    String uemail;
    String upassword;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "course_user",
            joinColumns = {
                    @JoinColumn(name = "uemail", referencedColumnName = "uemail",
                            nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "cid", referencedColumnName = "cid",
                            nullable = false)})
    private Set<Course> courses = new HashSet<>();
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
/*  public User(Set<Course> newcourse) {
        this.newcourse = newcourse;
    }

    @ManyToMany(mappedBy = "products")
    Set<Course> newcourse;

    public Set<Course> getNewcourse() {
        return newcourse;
    }

    public void setNewcourse(Set<Course> newcourse) {
        this.newcourse = newcourse;
    }*/

    public User()
    {}

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public User(Long uid, String uname, String umobilenumber, String uemail, String upassword) {
        this.uid = uid;
        this.uname = uname;
        this.umobilenumber = umobilenumber;
        this.uemail = uemail;
        this.upassword = upassword;
    }

    public String getUmobilenumber() {
        return umobilenumber;
    }

    public void setUmobilenumber(String umobilenumber) {
        this.umobilenumber = umobilenumber;
    }

    public String getUemail() { return uemail; }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
}
