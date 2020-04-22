package com.example.eventplanner.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    Long cid;
    String cname;
    String cduration;
    String csdate;
//  public   Long cflag;
    public String cflag;
    String cbrief;
    String cdetail;

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