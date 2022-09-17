package com.sanjit.springrest.services;

import com.sanjit.springrest.dao.CourseDao;
import com.sanjit.springrest.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service tell Spring that this is a service class that provides implementation at service layer.
@Service
public class CourseServiceImpl implements CourseServices {

//    List<Courses> list;

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {

//        list = new ArrayList<>();
//        list.add(new Courses(1, "a", "aaa"));
//        list.add(new Courses(2, "b", "bbb"));
//        list.add(new Courses(3, "c", "ccc"));
    }

    @Override
    public List<Courses> getCourses() {
//        return list;
        return courseDao.findAll();
    }

    @Override
    public Courses getCourse(long courseId) {
        Courses courses = null;

//        for (Courses c: list) {
//            if(c.getId() == courseId){
//                courses = c;
//                break;
//            }
//        }

        courses = courseDao.getReferenceById(courseId);
        return courses;
    }

    @Override
    public Courses addCourse(Courses courses) {
//        list.add(courses);
        courseDao.save(courses);
        return courses;
    }

    @Override
    public Courses updateCourse(Courses courses) {

//        list.forEach(c -> {
//            if(c.getId() == courses.getId()){
//                c.setTitle(courses.getTitle());
//                c.setDescription(courses.getDescription());
//            }
//        });
        courseDao.save(courses);
        return courses;
    }

    @Override
    public void deleteCourse(long courseId) {
//        Courses courses = null;
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).getId() == courseId){
//                courses = list.get(i);
//                list.remove(i);
//                break;
//            }
//        }
        Courses courseRef = courseDao.getReferenceById(courseId);
        courseDao.delete(courseRef);
    }


}
