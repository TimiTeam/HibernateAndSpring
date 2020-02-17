package com.gmail.timurworkspace.entity;

public interface Document {
    String getName();
    String getSerialNumber();
    User getUser();
    void setUser(User user);
}
