package com.demo.book.models;


import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name is required")
    private String name;

    @NotBlank(message="Email is required")
    @Email(message="Email must be valid")
    private String email;

    @NotBlank(message="Password is required")
    @Size(min=8, message="Password must be at least 8 characters")
    private String password;

    @Transient
    @NotBlank(message="Confirm Password is required")
    private String confirmPassword;

    @OneToMany(mappedBy="poster", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Book> books;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    protected void onCreate(){ this.createdAt = new Date(); }
    @PreUpdate
    protected void onUpdate(){ this.updatedAt = new Date(); }

    // getters/setters
    public Long getId(){ return id; }
    public void setId(Long id){ 
    	this.id = id; }
    public String getName(){ 
    	return name; }
    public void setName(String name){ 
    	this.name = name; }
    public String getEmail(){ 
    	return email; }
    public void setEmail(String email){ 
    	this.email = email; }
    public String getPassword(){
    	return password; }
    public void setPassword(String password){
    	this.password = password; }
    public String getConfirmPassword(){
    	return confirmPassword; }
    public void setConfirmPassword(String confirmPassword){
    	this.confirmPassword = confirmPassword; }
    public List<Book> getBooks(){
    	return books; }
    public void setBooks(List<Book> books){ 
    	this.books = books; }
}
