package com.demo.burger.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Burger name is required")
    private String name;

    @NotBlank(message="Restaurant name is required")
    private String restaurant;

    @Min(value=1, message="Rating must be at least 1")
    @Max(value=5, message="Rating must be at most 5")
    private int rating;

    @NotBlank(message="Notes are required")
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
