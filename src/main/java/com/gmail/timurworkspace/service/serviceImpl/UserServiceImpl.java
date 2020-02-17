package com.gmail.timurworkspace.service.serviceImpl;

import com.gmail.timurworkspace.dao.AbstractDao;
import com.gmail.timurworkspace.entity.DocumentFactory;
import com.gmail.timurworkspace.entity.User;
import com.gmail.timurworkspace.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements AbstractService<User> {

    private AbstractDao<User> dao;

    @Autowired
    public void setDao(AbstractDao<User> dao) {
        this.dao = dao;
    }

    @Override
    public void saveObject(User user) {
        if (user != null) {
            user.setDocument(DocumentFactory.createDocument("passport"));
            dao.saveObject(user);
        }
    }

    @Override
    public User getById(int id) {
        return dao.getById(id);
    }

    @Override
    public void deleteObject(User user) {
        if (user != null){
            dao.deleteObject(user);
        }
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }
}
