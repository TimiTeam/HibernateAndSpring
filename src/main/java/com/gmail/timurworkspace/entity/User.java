package com.gmail.timurworkspace.entity;

import com.gmail.timurworkspace.entity.documentPassport.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Passport.class)
    @JoinColumn(name = "passport_id")
    private Document document;


    public User() {
        if((this.document = DocumentFactory.createDocument("passport")) != null)
            document.setUser(this);
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        if((this.document = DocumentFactory.createDocument("passport")) != null)
            document.setUser(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
        document.setUser(this);
    }

    @Override
    public String toString() {
        return "User{id: " +id+
                ", name: " + name +
                ", email: " + email +
                ", password: " + password +
                '}';
    }
}
