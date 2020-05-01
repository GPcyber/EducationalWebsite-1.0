package com.example.eventplanner.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.example.eventplanner.model.User;
import com.example.eventplanner.model.Course;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="user_course")
public class appliedcourse {

    @Id
    Integer sno;
    String username;
    String useremail;
    Long cid;
    String cname;
    String cdetail;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
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

    public appliedcourse(String username, String useremail, Long cid, String cname, String cdetail) {
        this.username = username;
        this.useremail = useremail;
        this.cid = cid;
        this.cname = cname;
        this.cdetail = cdetail;
    }


    public appliedcourse(Integer sno) {
        this.sno = sno;
    }

    public appliedcourse() {
    }


}

