package com.example.demo.dao;

import com.example.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUsers(User user){

        Session session = sessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
    }

    public User getUserById(String user_id){

        User user= new User();
        Session session = sessionFactory.getCurrentSession();
        try {
            user = session.get(User.class,user_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUSer(){

        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from users", User.class).list();
        return userList;
    }

    public void updateUserId(User user){

        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void deleteUSer(String user_id){

        Session session = sessionFactory.getCurrentSession();
        User user = getUserById(user_id);
        try {
            session.delete(user);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
