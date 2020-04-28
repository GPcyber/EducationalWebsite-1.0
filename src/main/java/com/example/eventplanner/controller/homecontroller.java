package com.example.eventplanner.controller;

import com.example.eventplanner.model.Course;
import com.example.eventplanner.model.User;
import com.example.eventplanner.model.appliedcourse;
import com.example.eventplanner.model.enquirySubmit;
import com.example.eventplanner.repository.Courserepository;
import com.example.eventplanner.repository.UserRepository;
import com.example.eventplanner.repository.appliedRepository;
import com.example.eventplanner.repository.enquiryRepository;
import com.example.eventplanner.service.Courseservice;
//import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    appliedRepository appliedRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public String getActiveCoursehome (Model model) throws Exception{
        List entity=service.getActiveCourse();
        model.addAttribute("activecourse",entity);
        return "home";
    }
   /*
    @GetMapping("home")
    public String gethome()
    {
    return "home.html";
    }

    @GetMapping("/course")
    public String coursedetails()
    {
        return "Course Details.html";
    }*/
   @GetMapping("/course")
   public String getActiveCourse (Model model){
       List entity=service.getActiveCourse();
       model.addAttribute("activecourse",entity);
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
    /*4th update*/
    @GetMapping("/viewmore/course")
    public String getcoursedetails(Model model)
    {
        List entity=service.getActiveCourse();
        model.addAttribute("activecourse",entity);
        return "Course Details.html";
    }
    @GetMapping("/contact/{cid}")
    public String getenquiryfromcourses(Model model,@PathVariable("cid") Optional<Long> cid  ) throws Exception
    {

       if (cid.isPresent()) {
           Course entity = service.getCourseById(cid.get());
           model.addAttribute("course", entity);

       }
        return "Contact.html";
    }
    /* This code is for apply course controller*/

    @GetMapping("/apply/{cid}")
    public String applyCourse(Model model,@PathVariable("cid") Optional<Long> cid ) throws Exception
    {
     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     String currentPrincipalName = authentication.getName();
     Optional<User> newuser=userRepository.findById(currentPrincipalName);
     { if (newuser.isPresent())
       {
        User newuser1=service.getUserbyId(currentPrincipalName);
        String authname= newuser1.getUname();
         if(cid.isPresent())
           {
            Course entity = service.getCourseById(cid.get());
            appliedcourse newappliedcourse= new appliedcourse(currentPrincipalName,authname,entity.getCid(),entity.getCname(),entity.getCduration(),entity.getCsdate());
            appliedRepository.save(newappliedcourse);

           }

       }
     }
        return "userpage.html";
    }
}
