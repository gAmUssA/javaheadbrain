package com.javaheadbrain.experiments.spring.dao;

import com.javaheadbrain.experiments.spring.entity.Account;

import java.util.List;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 5/1/12
 */

public interface AccountDAO {


    int createAccount(double initialBalance);

    Account findAccountById(int id);

    List<Account> findAllAccounts();

    void updateAccount(Account account);

    void deleteAccount(int id);

}
