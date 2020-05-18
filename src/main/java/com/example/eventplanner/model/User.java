package com.example.eventplanner.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user" )
public class User  {


    Long uid;
    @Column(name = "name")
    String username;
    @Column(name = "mobileumber")
    String usermobile;
    @Id
    String useremail;

//    @Column(name = "Password")
//    @Length(min = 6, message = "*Your password must have at least 6 characters")
//    @Transient
    String userpassword;

/*    @Length(min = 6, message = "*Your password must have at least 6 characters")
    @Transient
    String cnfirmpassword;  */

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "course_user",
            joinColumns = {
                    @JoinColumn(name = "useremail", referencedColumnName = "useremail",
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

    public User()
    {}

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(Long uid, String username, String usermobile, String useremail, String userpassword) {
        this.uid = uid;
        this.username = username;
        this.usermobile = usermobile;
        this.useremail = useremail;
        this.userpassword = userpassword;
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile;
    }

    public String getUseremail() { return useremail; }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
