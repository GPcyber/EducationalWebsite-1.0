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
public class home {

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

    @GetMapping("home/Course Details")
    public String coursedetails()
    {
        return "Course Details.html";
    }
    @GetMapping("home/Contact")
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


 /*   @GetMapping("/save")
    public String saveEnquiry(@Param("name") String ename, @Param("qualification") String qualificatoion, @Param("email") String email,  @Param("number") String number,
                              @Param("courseID") String courseID) {

        enquirySubmit enquirysubmit=new enquirySubmit();
        enquirysubmit.setEname(ename);
        enquirysubmit.setQualification(qualificatoion);
        enquirysubmit.setEmail(email);
        enquirysubmit.setMobilephone(Integer.parseInt(number));
        enquirysubmit.setCourseID(Long.parseLong(courseID));


        enquiryrepository.save(enquirysubmit);
        return "Signup Successfully ";
    }*/

    @ResponseBody
    @PostMapping("/home/Contact/submit")
    public String enquirySubmit(@ModelAttribute enquirySubmit enquirysubmit){
        enquiryrepository.save(enquirysubmit);

        return "Your enquiry is placed";
    }
    @GetMapping("/home/admin")
    public String getAdmin()
    {
        return "adminhome.html";
    }
    @GetMapping("home/admin/logout")
    public String afterLogout()
    {
        return "home.html";
    }

    @GetMapping("home/admin/adminhome/adminlist")
    public String getProduct(Model model){
        model.addAttribute("adminlist",courserepository.findAll());
        return "adminlist";

    }
//needs rest framework
   //@GetMapping("/modify/{cid}")
 //  @RequestMapping(path = {"/modify/{cid}"})
   public String editEmployeeById(Model model, @PathVariable("cid") Optional<Long> cid) throws Exception {
       if (cid.isPresent()) {
           Course entity = service.getCourseById(cid.get());

           model.addAttribute("course", entity);

       } else {
           model.addAttribute("course", new Course());

       }

       return "adminadd";
   }
   /*
   @ResponseBody
    public String getModifydetails(@PathVariable("cid") String id ,@RequestBody Course course){
        Optional<Course> p=courserepository.findById(Long.parseLong(id));
        Course course1=null;
        if (p.isPresent()){
            course1=p.get();
            course1.setCid(course.getCid());
            course1.setCduration(course.getCduration());
            course1.setCname(course.getCname());
            course1.setCsdate(course.getCsdate());
            courserepository.save(course1);
            //model.addAttribute("Course Details",p.get());
        }
        return "hello";
        //return "forward:/home/admin/adminhome/adminlist";
    }
*/
    @GetMapping("/delete/{cid}")
    public String deleteCourse(@PathVariable("cid") String id )
    {
        courserepository.deleteById(Long.parseLong(id));
        return "redirect:/admin/courseDetails";
        //return "forward:/home/admin/adminhome/adminlist";
    }
    @RequestMapping(method = RequestMethod.GET,path = "/admin/courseDetails")
    public String getAllCourses(Model model)
    {
        List<Course> list = service.getAllCourses();

        model.addAttribute("course", list);
        return "adminlist";
    }

    /*@RequestMapping(method = RequestMethod.GET,path = "/admin/courseDetails")
    public String newgetAllCourses(Model model)
    {
        List<Course> list = service.getAllCourses();

        model.addAttribute("course", list);
        return "adminlist";
    }*/
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


    @ResponseBody
    @GetMapping("/activate/{cid}")
    public String activate(@PathVariable ("cid") Optional<Long> id) throws Exception{
        if (id.isPresent()) {
            Course entity = service.getCourseById(id.get());
           // entity.setCflag(Long.parseLong("1"));
            entity.setCflag(("1"));
            courserepository.save(entity);
            return "Activated Successufully";
        }
        else
            return "sorry this course is not activated";
    }

    @ResponseBody
    @GetMapping("/deactivate/{cid}")
    public String deactivate(@PathVariable ("cid") Optional<Long> id) throws Exception{
        if (id.isPresent()) {
            Course entity = service.getCourseById(id.get());
            //entity.setCflag(Long.parseLong("0"));
            entity.setCflag((""));
            courserepository.save(entity);
            return "Deactivated Successufully";
        }
        else
            return "sorry this course is not deactivated";
    }
    @GetMapping("/admin/activecourses")
    public String activecourse( Model model) throws Exception
    {
        //4 slashes the other method
       // List<Course> entity=service.getAllCourses();
    //// List entity=service.getCourseBycflag();
       // Course course1=new Course();
        //List<Course> list=courserepository.findAll();
       // Course cnewcourse= list.getClass();
       //if(list.contains(course1.getCflag()))
        List entity=service.getActiveCourse();
           model.addAttribute("activelist",entity);
           return "activelist";
    }

    @RequestMapping(path = {"/admin/activate/{uemail}"})
    public String activateasAdmin(Model model,@PathVariable ("uemail") Optional<String> email) throws Exception
    {
        if(email.isPresent()) {
            User enitity = service.getUserbyId(email.get());
            enitity.setUid(Long.parseLong("2"));
            userRepository.save(enitity);
        }
        return "redirect:/admin/userlist";
    }
    @RequestMapping(path = {"/admin/deactivate/{uemail}"})
    public String deactivateasAdmin(@PathVariable ("uemail") Optional<String> email) throws Exception
    {
        if(email.isPresent()) {
            User enitity = service.getUserbyId(email.get());
            enitity.setUid(Long.parseLong("1"));
            userRepository.save(enitity);
        }
        return "redirect:/admin/userlist";
    }

}
