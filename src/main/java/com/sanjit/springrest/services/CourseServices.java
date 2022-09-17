package com.sanjit.springrest.services;

import com.sanjit.springrest.entities.Courses;

import java.util.List;

public interface CourseServices {

    // To lose coupling, run-time polymorphism.
    public List<Courses> getCourses();

    public Courses getCourse(long courseId);

    public Courses addCourse(Courses courses);

    public Courses updateCourse(Courses courses);

    public void deleteCourse(long courseId);
}
