package com.sanjit.springrest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

// TO make Course class as Entity so that to use it in DB. Hibernate understand it as entity
@Entity
public class Courses {

    @Id
    private long id;
    private String title;
    private String description;

    public Courses(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Courses() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Overriding toString using built-in method
    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
