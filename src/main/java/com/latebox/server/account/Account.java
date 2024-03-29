package com.latebox.server.account;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Account {

    private @Id
    @GeneratedValue
    Long id;
    private String fullName;
    private String email;
    private String password;


    private String phone;
    @NotNull
    private String userType;

    public Account(){
    }
    public Account(String fullName, String email, String password, String phone, String userType){
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {return fullName; }

    public void setFullName(String fullName) {this.fullName = fullName; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}


//// This interface is specifically created to continue using JPA to get users emails.
//// I was able to write simply a query instead to get the emails' column only,
//// But I'll be in the risk of exposing the passwords' column as well in case of a SQL injection.
//// this is called projections in Spring check the following URL
//// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections
//public interface AccountEmailOnly extends JpaRepository<Account, Long> {
//    String getEmail();
//}

