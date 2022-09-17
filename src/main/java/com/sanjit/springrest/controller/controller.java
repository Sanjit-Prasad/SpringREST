package com.sanjit.springrest.controller;

import com.sanjit.springrest.entities.Courses;
import com.sanjit.springrest.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    // Interface object of CourseServiceImpl to do lose coupling.
    // Using Autowired we do not have to create object by us. Spring will do it.
    // Also add @Component on CourseServices class.
    @Autowired
    private CourseServices courseServices;

    @GetMapping("/home")
    public String home() {
        return "You're on Homepage";
    }

    // Return list of courses
    @GetMapping("/courses")
    public List<Courses> getCourses() {

        return  this.courseServices.getCourses();
    }

    // Return course/id.
    @GetMapping("/courses/{id}")
    public Courses getCourse(@PathVariable("id") String courseId) {

        return this.courseServices.getCourse(Long.parseLong(courseId));
    }

    // Add new course
    @PostMapping(path="/courses", consumes = "application/json")
    public Courses addCourse(@RequestBody Courses courses) {
        return this.courseServices.addCourse(courses);
    }

    @RequestMapping(path="/courses", method = RequestMethod.PUT)
    public Courses updateCourse(@RequestBody Courses courses) {
        return this.courseServices.updateCourse(courses);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") String courseId) {
        try {
            this.courseServices.deleteCourse(Long.parseLong(courseId));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

/**
 * @Controller annotation is used to tell that this class is a controller class.
 * @RestController annotation is used to tell that this class is a data controller class.
 * @GetMapping is used to map get method calls to a method
 * @PostMapping
 * @RequestMapping ->
 *
 */