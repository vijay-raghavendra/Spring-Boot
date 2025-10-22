package com.aim2code.hibernate.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "comment")
    private String Comment;

    public Review() {
    }

    public Review(String comment) {
        Comment = comment;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "Id=" + Id +
                ", Comment='" + Comment + '\'' +
                '}';
    }
}
