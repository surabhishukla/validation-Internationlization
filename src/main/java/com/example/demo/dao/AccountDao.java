package com.example.demo.dao;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.request.AccountRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addAccount(Account account){

        Session session= sessionFactory.openSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            session.saveOrUpdate(account);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }

    public Account getAccountById(String account_id){

        Session session=sessionFactory.getCurrentSession();
        Account account=session.get(Account.class,account_id);
        return account;
    }

    public List<Account> getAllAccount(){

        Session session=sessionFactory.getCurrentSession();
        List<Account> accountList= session.createQuery("from Account",Account.class).list();
        return accountList;
    }

    public void updateAccount(String account_no,AccountRequest accountRequest){
        Session session= sessionFactory.getCurrentSession();
        Account account= new Account();
        account.setAccount_no(account_no);
        account.setOpening_date(accountRequest.getOpening_date());
        account.setBalance(accountRequest.getBalance());
        account.setAccount_type(accountRequest.getAccount_type());
        account.setUser_id(accountRequest.getUser_id());
        account.setPassbook(accountRequest.getPassbook());
        session.update(accountRequest);
    }

    public void deleteAccount(String account_id){
        Session session= sessionFactory.getCurrentSession();
        Account account= getAccountById(account_id);
        try {
            session.delete(account);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //1.fetch opened account b/w any two dates
    public List<String> getAccountBetweenDate(String first_date, String second_date) throws Exception{
        Session session= sessionFactory.getCurrentSession();
        List<String> accountList= session.createQuery("select account_no from Account where date(opening_date) BETWEEN '"+first_date+"' AND '"+second_date+"'",String.class).list();
        return AccountDto.AccountBtwDate(accountList);
    }

    //2. find AVG account_balance for any account_type
    public List<Double> getAvgBalance(String account_type)  {
        Session session = sessionFactory.getCurrentSession();
        List<Double> accountList =  session.createQuery("select avg(balance) from Account where account_type='"+account_type+"'", Double.class).list();
        return AccountDto.getAvgBalance(accountList);
    }

    //3. get account balance by passbook id
    public List<Account> getBalanceByPassbook(String passbook_id) throws Exception{
        Session session= sessionFactory.getCurrentSession();
        List<Account> accountList= session.createQuery("select a.balance from Account a, Passbook p where p.passbook_id='"+passbook_id+"'").list();
        return AccountDto.getBalanceByPassbook(accountList);
    }

    //4. get accounts grouped by account_type
    public List<Account> getAccountByType() throws Exception{
        Session session= sessionFactory.getCurrentSession();
        List<Account> accountList= session.createQuery("select account_type, COUNT(account_no) from Account group by account_type").list();
        return accountList;
    }

}
