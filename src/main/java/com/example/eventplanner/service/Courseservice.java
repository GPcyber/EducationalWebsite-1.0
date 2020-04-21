package com.example.eventplanner.service;


import com.example.eventplanner.model.Course;
import com.example.eventplanner.model.User;
import com.example.eventplanner.repository.Courseinterface;
import com.example.eventplanner.repository.Courserepository;
import com.example.eventplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//implements Courseinterface
public class Courseservice  {
    @Autowired
    Courserepository courserepository;
    @Autowired
    UserRepository userRepository;

    public List<Course> getAllCourses()
    {
        List<Course> result = courserepository.findAll();


            return result;

    }
    public List<Course> getCourseBycflag() throws Exception {
        //Course course2=courserepository.findAll();;
        Course course1 = new Course();
        List<Course> courses = courserepository.findAll();
        List<Course> flitercourse = new ArrayList<>();

        for(Course c:courses)
        {
            if(c.getCflag().equals("1"))

            {flitercourse.add(c);

            }

        }

        return flitercourse;

    }

    public Course getCourseById(Long cid) throws Exception {
        Optional<Course> course = courserepository.findById(cid);
        {
        if (course.isPresent())

            return course.get();
    }
    return new Course();
    }
    public Course updateCourse(Course course)
    {
        if(course.getCid()  == null)
        {
            course = courserepository.save(course);

            return course;
        }
        else
        {
            Optional<Course> employee = courserepository.findById(course.getCid());

            if(employee.isPresent())
            {
                Course cnewcourse= employee.get();
                cnewcourse.setCname(course.getCname());
                cnewcourse.setCsdate(course.getCsdate());
                cnewcourse.setCduration(course.getCduration());
                cnewcourse.setCid(course.getCid());

                cnewcourse = courserepository.save(cnewcourse);

                return cnewcourse;
            } else {
                course = courserepository.save(course);

                return course;
            }
        }
    }

    public List<Course> getActiveCourse() {
        return courserepository.activecourses("1");

    }

    public User getUserbyemail(User user) {
        if(user.getUemail()  == null)
        {
            user = userRepository.save(user);

            return user;
        }
        else
        {
            Optional<User> employee = userRepository.findById(user.getUemail());

            if(employee.isPresent())
            {
                User cnewcourse= employee.get();

                cnewcourse.setUpassword(user.getUpassword());

                cnewcourse = userRepository.save(cnewcourse);

                return cnewcourse;
            } else {
                user = userRepository.save(user);

                return user;
            }
        }

    }
    public User getUserbyId(String email){
        Optional<User> user = userRepository.findById(email);
        {
            if (user.isPresent())
                return user.get();
    }
    return new User();
    }
}
