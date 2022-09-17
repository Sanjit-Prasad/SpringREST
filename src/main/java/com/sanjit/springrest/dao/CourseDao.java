package com.sanjit.springrest.dao;

import com.sanjit.springrest.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Courses, Long> {

    //JpaRepository contains <Main entity, Primary key>

}
