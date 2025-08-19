package com.demo.burger.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="burgers")  // اسم الجدول في قاعدة البيانات
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Burger Name is required")
    private String name;

    @NotBlank(message="Restaurant Name is required")
    private String restaurant;

    @NotNull
    @Min(value=1, message="Rating must be at least 1")
    @Max(value=5, message="Rating cannot be more than 5")
    private Integer rating;

    @NotBlank(message="Notes must not be blank")
    private String notes;

    // ======== Getters and Setters =========
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

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
