package com.gmail.timurworkspace.dao.daoImpl;

import com.gmail.timurworkspace.dao.AbstractDao;
import com.gmail.timurworkspace.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements AbstractDao<User>, Serializable {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void saveObject(User user) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage()+"\n"+e.getCause());
        }
    }

    @Override
    @Transactional
    public User getById(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage()+"\n"+e.getCause());
        }
        return user;
    }

    @Override
    @Transactional
    public void deleteObject(User user) {
        if (user == null)
            return;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage()+"\n"+e.getCause());
        }
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return null;
    }

}
