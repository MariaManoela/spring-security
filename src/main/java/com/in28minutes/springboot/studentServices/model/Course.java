package com.in28minutes.springboot.studentServices.model;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Course {
    private String id;
    private String name;
    private String description;
    private List<String> steps;
}
