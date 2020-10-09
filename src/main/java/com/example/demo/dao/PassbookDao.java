package com.example.demo.dao;

import com.example.demo.dto.PassbookDto;
import com.example.demo.entity.Passbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PassbookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addPassbook(Passbook passbook){

        Session session=sessionFactory.openSession();
        Transaction transaction= null;
        try {
            transaction=session.beginTransaction();
            session.saveOrUpdate(passbook);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }

    public Passbook getPassbookById(String passbook_id){

        Session session= sessionFactory.getCurrentSession();
        Passbook passbook= session.get(Passbook.class,passbook_id);
        return passbook;
    }

    public List<Passbook> getAllPassbook(){

        Session session= sessionFactory.getCurrentSession();
        List<Passbook> passbookList= session.createQuery("from passbook",Passbook.class).list();
        return passbookList;
    }

    public void updatePassbook(Passbook passbook){

        Session session= sessionFactory.getCurrentSession();
        session.update(passbook);
    }

    public void deletePassbook(String passbook_id){

        Session session= sessionFactory.getCurrentSession();
        Passbook passbook= getPassbookById(passbook_id);
        try {
            session.delete(passbook);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // 5. get number of accounts for a branch
    public List<Long> getAccountForBranch(String branch){
        Session session= sessionFactory.getCurrentSession();
        List<Long> accountList= session.createQuery("select COUNT(account_no) from Passbook  where branch='"+branch+"'", Long.class).list();
//        return accountList;
        return PassbookDto.getAccountForBranch(accountList);
    }
}
