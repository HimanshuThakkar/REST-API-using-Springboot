package com.example.simplerestapis.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.simplerestapis.models.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountServiceController {
    private static Map<String, Account> accountRepository = new HashMap<>();
    static {
        Account account1 = new Account();

        account1.setId("123");
        account1.setName("John Smith");
        account1.setAccountType("Checking");
        account1.setAccountNumber(124523);
        accountRepository.put(account1.getId(), account1);

        Account account2 = new Account();
        account2.setId("213");
        account2.setName("Smith Kelly");
        account2.setAccountType("Saving");
        account2.setAccountNumber(123423);
        accountRepository.put(account2.getId(), account2);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        accountRepository.remove(id);
        return new ResponseEntity<>("Account is deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Account account) {
        accountRepository.remove(id);
        account.setId(id);
        accountRepository.put(id, account);
        return new ResponseEntity<>("Account is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Account account) {
        accountRepository.put(account.getId(), account);
        return new ResponseEntity<>("Account is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping("/accounts")
    public ResponseEntity<Object> getProduct() {
        return new ResponseEntity<>(accountRepository.values(), HttpStatus.OK);
    }
}