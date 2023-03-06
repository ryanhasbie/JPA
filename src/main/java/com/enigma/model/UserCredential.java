package com.enigma.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users_credentials")
public class UserCredential {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "userCredential", cascade = CascadeType.PERSIST)
    private Student student;

    public String getEmail() {
        return email;
    }

    public UserCredential(String email, String password, Student student) {
        this.email = email;
        this.password = password;
        this.student = student;
    }

    public UserCredential() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
