package com.aim2code.hibernate.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "email")
    private String Email;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.REFRESH,CascadeType.PERSIST},mappedBy = "students")
    private List<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCouses(Course course)
    {
        if (courses == null)
        {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.addStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
