package com.example.eventplanner.controller;

import com.example.eventplanner.model.Course;
import com.example.eventplanner.model.User;
import com.example.eventplanner.model.enquirySubmit;
import com.example.eventplanner.repository.Courserepository;
import com.example.eventplanner.repository.UserRepository;
import com.example.eventplanner.repository.enquiryRepository;
import com.example.eventplanner.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class homecontroller {

    @Autowired
    Courserepository courserepository;
    @Autowired
    enquiryRepository enquiryrepository;
    @Autowired
    Courseservice service;
    @Autowired
    UserRepository userRepository;


    @GetMapping("home")
    public String gethome()
    {
    return "home.html";
    }

    @GetMapping("/course")
    public String coursedetails()
    {
        return "Course Details.html";
    }
    @GetMapping("/contact")
    public String getContact()
    {
        return "Contact.html";
    }
    @GetMapping("/login")
    public String getlogin()
    {
       return  "Login.html";
    }

    @GetMapping("home/userpage")
    public String getUserpage()
    {
        return  "userpage.html";
    }


    @PostMapping("/contact/enquirysubmit")
    public String enquirySubmit(@ModelAttribute enquirySubmit enquirysubmit){
        enquiryrepository.save(enquirysubmit);

        return "Contact.html";
    }

}
