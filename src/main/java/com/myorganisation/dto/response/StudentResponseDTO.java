package com.myorganisation.dto.response;

import com.myorganisation.model.enums.Gender;

public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Gender gender;
    private String course;

    // Constructors
    public StudentResponseDTO() {}

    public StudentResponseDTO(Long id, String name, String email, Gender gender, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.course = course;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
