package com.latebox.server.account;

import com.latebox.server.account.Account;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

@CrossOrigin(origins = "http://localhost:19006")
@RestController
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }
    @CrossOrigin(origins = "http://localhost:19006")
    @GetMapping("/accounts")
    List<Account> all(){
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:19006")
    @GetMapping("/accounts/{email}")
    List<Account> allEmail(@PathVariable String email){
        List<Account> results = repository.findByEmail(email);
        // We need to return back the users list without passwords.
        return results;
    }

    @PostMapping("/accounts")
    Account newProduct(@RequestBody Account newAccount){

        Account hashedAccount = newAccount;

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        String uncookedPass = newAccount.getPassword();

        digest.update(uncookedPass.getBytes(StandardCharsets.UTF_8));
        byte[] digested = digest.digest();

        String coockedPass = String.format("%064x", new BigInteger(1, digested));
        hashedAccount.setPassword(coockedPass);

        return repository.save(hashedAccount);
    }
}
