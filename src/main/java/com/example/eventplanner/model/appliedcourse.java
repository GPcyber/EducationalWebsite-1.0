package com.example.eventplanner.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_course")
public class appliedcourse {
    @Id
    String uemail;
    String uname;
    Long cid;
    String cname;
    String cduration;
    String csdate;

    public appliedcourse()
    {

    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
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



    public appliedcourse(String uemail, String uname, Long cid, String cname, String cduration, String csdate) {
        this.uemail = uemail;
        this.uname = uname;
        this.cid = cid;
        this.cname = cname;
        this.cduration = cduration;
        this.csdate = csdate;

    }
}
