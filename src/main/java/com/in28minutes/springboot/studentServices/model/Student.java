package com.in28minutes.springboot.studentServices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Student {
    private String id;
    private String name;
    private String description;
    private List<Course> courses;
}
