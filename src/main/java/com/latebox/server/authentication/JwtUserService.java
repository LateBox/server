package com.latebox.server.authentication;

import com.latebox.server.account.Account;
import com.latebox.server.account.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserService implements UserDetailsService {
    private final AccountRepository repository;

    public JwtUserService(AccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // check if username exists in database
        List<Account> foundAccount = repository.findByEmail(username);
        String email = foundAccount.get(0).getEmail();
        String password=foundAccount.get(0).getPassword();
        if (username.equals(email)) {
            // change to return username and encrypted password from the database
            return new User(username, password,
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}