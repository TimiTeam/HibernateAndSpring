package com.gmail.timurworkspace;

import com.gmail.timurworkspace.config.AppConfig;
import com.gmail.timurworkspace.entity.User;
import com.gmail.timurworkspace.service.AbstractService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    public static List<User> createUsers(ApplicationContext context, int count){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; ++i){
            users.add(context.getBean("user", User.class));
        }
        return users;
    }


    public static void main( String[] args )
    {

        //ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AbstractService service =(AbstractService)context.getBean("userService");

        service.saveObject(new User("hello", "test@mail.com", "pass1234"));

        User u = (User)service.getById(1);

        System.out.println(u+" "+u.getDocument());
    }
}
