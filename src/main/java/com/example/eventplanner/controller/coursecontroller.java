package com.example.eventplanner.controller;

//import com.example.Eduinstitute.model.Course;
//import com.example.Eduinstitute.repositry.Courserepository;
import com.example.eventplanner.model.Course;
import com.example.eventplanner.model.User;
import com.example.eventplanner.repository.Courserepository;
import com.example.eventplanner.repository.UserRepository;
import com.example.eventplanner.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class coursecontroller {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Courserepository courserepository;
    @Autowired
    Courseservice service;
/*
    @GetMapping("/save2")
    //@ResponseBody
    public String saveCourse(@Param("cid") Long cid, @Param("cname") String cname, @Param("cduration") String cduration, @Param("csdate") String csdate) {

        Course course = new Course();
        course.setCid(cid);
        course.setCname(cname);
        course.setCduration(cduration);
        course.setCsdate(csdate);

        courserepository.save(course);
        return "Entered Successfully ";
    }
  //  @GetMapping("/admin/courseDetails")
  //  public String showcourse(Model model)

  //  {
  //      model.addAttribute("adminlist",courserepository.findAll());
   //     return "adminlist";
   //  }

    @PostMapping("/save3")
   // @ResponseBody
    public String saveCourse2(@ModelAttribute Course course) {
        courserepository.save(course);
        return "redirect:/admin/courseDetails";
    }

   /* @PostMapping("/save4")

    public String saveCourse4(@ModelAttribute Course course,@PathVariable("cid") String id) {
        courserepository.deleteById(Long.parseLong(id));
        courserepository.save(course);
        return "redirect:/admin/courseDetails";
    }*/

    @GetMapping("/home/login/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/admin/signup")
    public String signupLogin(@ModelAttribute User user)
    {
        user.setUid(Long.parseLong("1"));
        userRepository.save(user);
        return "redirect:/home/";
    }
    @GetMapping("/admin/userlist")
    public String AdminUserList(Model model)
    {   List<User>entity =userRepository.findAll();
        model.addAttribute("user",entity);
        return "adminuserlist.html"; }


    @GetMapping("/home/forgetpasswordhome")
    public String gethome()
    {
        return "forgetpasswordhome.html";
    }

    @RequestMapping (path={"/forgetpassword/"},method = RequestMethod.POST)
    //updation display seems not to be working
    public  String forgetpassword(@RequestParam("uemail")Optional<String> mail,Model model) throws Exception

    {
        if (mail.isPresent())

    {       User entity = service.getUserbyId(mail.get());
            model.addAttribute("user", entity);
        } else {
            model.addAttribute("user", new User());
        }
        return "forgetpassword";
    }

    @PostMapping("/admin/signuppass")
    public String userLogin1(@ModelAttribute User user)
    {
        userRepository.save(user);
        return "redirect:/home/";
    }
    @GetMapping("/login/user")
    public String userLogin(@ModelAttribute User user) {


      /* List<User>entity=userRepository.findAll();
        for(User u:entity)
        {
            boolean s=((user.getUemail().equals(u.getUemail())) && (user.getUemail().equals(u.getUemail())));
          // boolean s=((u.getUemail().equals(user.getUemail())) && (u.getUpassword().equals(user.getUpassword())));

            if (s==true)
                return "redirect:/home/";

            else
                continue;
        }
        //if (s==false)

            return "adminlist";

    }*/
       return "homeafterlogin";
    }
}