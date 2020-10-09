package com.example.demo.dao;

import com.example.demo.entity.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class BankDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBank(Bank bank){

        Session session= sessionFactory.openSession();
        Transaction transaction= null;
        try {
            transaction=session.beginTransaction();
            session.saveOrUpdate(bank);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }

    public Bank getBankById(String bank_id){

        Session session= sessionFactory.getCurrentSession();
        Bank bank = session.get(Bank.class,bank_id);
        return bank;
    }

    public List<Bank> getAllBank(){

        Session session= sessionFactory.getCurrentSession();
        List<Bank> bank= session.createQuery("from banks", Bank.class).list();
        return bank;
    }

    public void updateBank(Bank bank){

        Session session= sessionFactory.getCurrentSession();
        session.update(bank);
    }

    public void deleteBank(String bank_id){

        Session session= sessionFactory.getCurrentSession();
        Bank bank= getBankById(bank_id);
        try {
            session.delete(bank);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
