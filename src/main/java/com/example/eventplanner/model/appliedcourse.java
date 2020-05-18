package com.example.eventplanner.model;

import javax.persistence.*;

@Entity
@Table(name="user_course")
public class appliedcourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public Integer sno;

    @Column(name = "name")
    String applieduser;

    @Column(name = "email")
    String appliedemail;

    Long cid;

    @Column(name = "coursename")
    String cname;

    @Column(name = "coursedetail")
    String cdetail;

    @Column(name = "startdate")
   public String cdate;

    public appliedcourse(Integer sno, String applieduser, String appliedemail, Long cid, String cname, String cdetail, String cdate) {
        this.sno = sno;
        this.applieduser = applieduser;
        this.appliedemail = appliedemail;
        this.cid = cid;
        this.cname = cname;
        this.cdetail = cdetail;
        this.cdate = cdate;
    }

    public String getApplieduser() {
        return applieduser;
    }

    public void setApplieduser(String applieduser) {
        this.applieduser = applieduser;
    }

    public String getAppliedemail() {
        return appliedemail;
    }

    public void setAppliedemail(String appliedemail) {
        this.appliedemail = appliedemail;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdetail() {
        return cdetail;
    }

    public void setCdetail(String cdetail) {
        this.cdetail = cdetail;
    }

    public appliedcourse(Integer sno) {
        this.sno = sno;
    }

    public appliedcourse() {
    }


}

