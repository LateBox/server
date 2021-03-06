package com.latebox.server.account;

import com.latebox.server.account.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/accounts")
//    List<Account> all(){
//        return repository.findAll();
//    }

    @GetMapping("/accounts/{email}")
    List<Account> allEmail(@PathVariable String email){
        List<Account> results = repository.findByEmail(email);
        // We need to return back the users list without passwords.
        return results;
    }

    @PostMapping("/accounts")
    Account newProduct(@RequestBody Account newAccount){
        return repository.save(newAccount);
    }
}
