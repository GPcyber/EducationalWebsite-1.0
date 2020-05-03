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
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;
@Transactional
@Controller
public class homecontroller {
    @PersistenceContext
    EntityManager entityManager = null;

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
        // try and pass the values of user and his email address
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<User> newuser=userRepository.findById(currentPrincipalName);
        { if (newuser.isPresent())

            {User newuser1=service.getUserbyId(currentPrincipalName);
                {
                    if (cid.isPresent()) {
                        Course entity = service.getCourseById(cid.get());
                        enquirySubmit enquirysubmit = new enquirySubmit(entity.getCid(), newuser1.getUname(), Integer.parseInt(newuser1.getUmobilenumber()), currentPrincipalName);
                        model.addAttribute("enquirysubmitdetails", enquirysubmit);
                    }

                    if (cid.isPresent()) {
                        Course entity = service.getCourseById(cid.get());
                        model.addAttribute("course", entity);

                    }

                }
            }
        }
        return "Contact.html";
    }
    /* This code is for apply course controller*/

    @GetMapping("/apply/{cid}")
    @Transactional
    public String applyCourse(Model model,@PathVariable("cid") Optional<Long> cid ,appliedcourse appliedcourse) throws Exception
    {
     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     String currentPrincipalName = authentication.getName();
     String CurrentName=getusername();
     if(CurrentName.isEmpty())
     {
         return "error.html";
     }
     else
     {
     Optional<User> newuser=userRepository.findById(currentPrincipalName);
     {
       if (newuser.isPresent())
        {
          User newuser1=service.getUserbyId(currentPrincipalName);

          String authname= newuser1.getUname();
            if(cid.isPresent())
           {
            Course entity = service.getCourseById(cid.get());
            //appliedcourse newappliedcourse= new appliedcourse(currentPrincipalName,authname,entity.getCid(),entity.getCname(),entity.getCduration());
               entityManager.createNativeQuery("INSERT INTO user_course (username, useremail ,cid , cname, cdate, cdetail) VALUES (?,?,?,?,?,?)")

                     //  .setParameter(1,@GeneratedValue(strategy = GenerationType.IDENTITY))
                       .setParameter(1,authname)
                       .setParameter(2,currentPrincipalName)
                       .setParameter(3,entity.getCid())
                       .setParameter(4,entity.getCname())
                       .setParameter(5,entity.getCsdate())
                       .setParameter(6,entity.getCdetail())
                       .executeUpdate();

            Set<Course> ent=newuser1.getCourses();
            ent.add(entity);
            userRepository.save(newuser1);

           }

        }
     }
        return "userpage.html";
     }
    }
    public String getusername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        {
        if (!(authentication instanceof AnonymousAuthenticationToken))
        {
            String currentUserName = authentication.getName();
            return currentUserName;
        }
        }
        String PrincipalName = "Hello this user is not signed in";
        return PrincipalName;
    }
}
