package com.gmail.timurworkspace.entity.documentPassport;

import com.gmail.timurworkspace.entity.Document;
import com.gmail.timurworkspace.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "passport")
public class Passport implements Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "serial")
    private String serialNumber;
    @OneToOne(mappedBy = "document")
    private User user;

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return '\''+name +
                ". Serial number: "+serialNumber+
                +'\'';
    }
}
