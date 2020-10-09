package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "passbook")
public class Passbook {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String passbook_id;

    @NotNull
    private String branch;

    @NotNull
    private String ifsc_code;

    @OneToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "account_no",nullable = false)
    private Account account;

    public String getPassbook_id() {
        return passbook_id;
    }

    public void setPassbook_id(String passbook_id) {
        this.passbook_id = passbook_id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
