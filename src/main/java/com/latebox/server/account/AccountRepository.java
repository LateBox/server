package com.latebox.server.account;

import com.latebox.server.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository  extends JpaRepository<Account, Long> {

    // I didn't use the Hibernate Query because I'm risking an exposure of the passwords in case of a SQL injection
    List<Account> findByEmail(String email);

    Account findById(long id);
}
