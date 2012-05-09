package com.javaheadbrain.experiments.spring.service;

import com.javaheadbrain.experiments.spring.dao.AccountDAO;
import com.javaheadbrain.experiments.spring.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 5/1/12
 */

@Service
@Transactional
public class AccountService {

    public static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Inject
    @Named("myBatisAccountDAO")
    private AccountDAO dao;


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public double getAccountBalance(int id) {
        Account account = dao.findAccountById(id);
        logger.info("{}", account);
        return account.getBalance();
    }

    public double depositIntoAccount(int id, double amount) {
        Account account = dao.findAccountById(id);
        account.deposit(amount);
        dao.updateAccount(account);
        return account.getBalance();
    }

    public double withdrawFromAccount(int id, double amount) {
        Account account = dao.findAccountById(id);
        account.withdraw(amount);
        dao.updateAccount(account);
        return account.getBalance();
    }

    public boolean tranferFunds(int fromId, int toId, double amount) {
        Account from = dao.findAccountById(fromId);
        Account to = dao.findAccountById(toId);
        from.withdraw(amount);
        to.deposit(amount);
        dao.updateAccount(from);
        dao.updateAccount(to);
        return true;
    }


}
