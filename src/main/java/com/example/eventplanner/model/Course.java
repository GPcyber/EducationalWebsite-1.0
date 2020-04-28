package com.example.eventplanner.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    public Long cid;
    String cname;
    String cduration;
    String csdate;
//  public   Long cflag;
    public String cflag;
    String cbrief;
    String cdetail;

    /*@ManyToMany()
    @JoinTable(
            name = "course_user",
            joinColumns = {@JoinColumn(name = "cid")},
            inverseJoinColumns = {@JoinColumn(name = "uemail")}

    )
    Set<User> newuser;

    public Course(Set<User> newuser) {
        this.newuser = newuser;
    }

    public Set<User> getNewuser() {
        return newuser;
    }

    public void setNewuser(Set<User> newuser) {
        this.newuser = newuser;
    }*/

    public Course(String cflag) {
        this.cflag = cflag;
    }

    public Course(Long cid, String cname, String cduration, String csdate, String cflag, String cbrief, String cdetail) {
        this.cid = cid;
        this.cname = cname;
        this.cduration = cduration;
        this.csdate = csdate;
        this.cflag = cflag;
        this.cbrief = cbrief;
        this.cdetail = cdetail;
    }

    public String getCflag() {
        return cflag;
    }

    public void setCflag(String cflag) {
        this.cflag = cflag;
    }

    public String getCname() {
        return cname;
    }

    public String getCbrief() {
        return cbrief;
    }

    public void setCbrief(String cbrief) {
        this.cbrief = cbrief;
    }

    public String getCdetail() {
        return cdetail;
    }

    public void setCdetail(String cdetail) {
        this.cdetail = cdetail;
    }
/* public Course(Long cid, String cname, String cduration, String csdate, Long cflag) {
        this.cid = cid;
        this.cname = cname;
        this.cduration = cduration;
        this.csdate = csdate;
        this.cflag = cflag;
    }

    public Course(Long cflag) {
        this.cflag = cflag;
    }

    public Long getCflag() {
        return cflag;
    }

    public void setCflag(Long cflag) {
        this.cflag = cflag;
    }*/

    public Course() {

    }


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname(Course course) {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCduration() {
        return cduration;
    }

    public void setCduration(String cduration) {
        this.cduration = cduration;
    }

    public String getCsdate() {
        return csdate;
    }

    public void setCsdate(String csdate) {
        this.csdate = csdate;
    }
}