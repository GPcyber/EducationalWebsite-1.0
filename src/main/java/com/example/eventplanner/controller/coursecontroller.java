package com.example.eventplanner.controller;

import com.example.eventplanner.model.Course;
import com.example.eventplanner.repository.Courserepository;
import com.example.eventplanner.repository.UserRepository;
import com.example.eventplanner.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/save3")
     public String saveCourse2(@ModelAttribute Course course) {
        courserepository.save(course);
        return "redirect:/home/admin";    }


    @GetMapping("home/admin/adminhome/adminlist")
    public String getCourseList(Model model){
        model.addAttribute("adminlist",courserepository.findAll());
        return "adminlist";
    }

    @GetMapping("/delete/{cid}")
    public String deleteCourse(@PathVariable("cid") String id )
    {
        courserepository.deleteById(Long.parseLong(id));
        return "redirect:/admin/courseDetails";
    }

    @RequestMapping(method = RequestMethod.GET,path = "/admin/courseDetails")
    public String getAllCourses(Model model)
    {
        List<Course> list = service.getAllCourses();
        model.addAttribute("course", list);
        return "adminlist";
    }

    @RequestMapping(path = {"/modify/{cid}"})
    public String neweditEmployeeById(Model model, @PathVariable("cid") Optional<Long> cid) throws Exception {
        if (cid.isPresent()) {
            Course entity = service.getCourseById(cid.get());
            model.addAttribute("course", entity);

        } else {
            model.addAttribute("course", new Course());
        }
        return "modifycourseadd";
    }

    @GetMapping("/activate/{cid}")
    public String activate(@PathVariable ("cid") Optional<Long> id) throws Exception{
        if (id.isPresent()) {
            Course entity = service.getCourseById(id.get());
            entity.setCflag(("1"));
            courserepository.save(entity);
            return "redirect:/admin/courseDetails";
        }
        else
            return "sorry this course is not activated";
    }

    @GetMapping("/deactivate/{cid}")
    public String deactivate(@PathVariable ("cid") Optional<Long> id) throws Exception{
        if (id.isPresent()) {
            Course entity = service.getCourseById(id.get());

            entity.setCflag((""));
            courserepository.save(entity);
            return "redirect:/admin/courseDetails";
        }
        else
            return "sorry this course is not deactivated";
    }

    @GetMapping("/admin/activecourses")
    public String activecourse( Model model) throws Exception
    {
        //4 slashes the other method
        /* List<Course> entity=service.getAllCourses();
         List entity=service.getCourseBycflag();
         Course course1=new Course();
         List<Course> list=courserepository.findAll();
         Course cnewcourse= list.getClass();
         if(list.contains(course1.getCflag()))*/
        List entity=service.getActiveCourse();
        model.addAttribute("activelist",entity);
        return "activelist";
    }

}