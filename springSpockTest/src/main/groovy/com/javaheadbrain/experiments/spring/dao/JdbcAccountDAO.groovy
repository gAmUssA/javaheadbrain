package com.javaheadbrain.experiments.spring.dao

import com.javaheadbrain.experiments.spring.entity.Account
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

import java.sql.ResultSet
import javax.inject.Inject
import javax.sql.DataSource

/**
 * TODO
 *
 * @since 5/1/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 */

@Repository
class JdbcAccountDAO implements AccountDAO {
    static int nextId = 3

    @Inject JdbcAccountDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource)
    }

    JdbcTemplate jdbcTemplate

    def accountMapper = {ResultSet rs, int row ->
        // construction of groovy object
        new Account(id: rs.getInt('id'), balance: rs.getDouble('balance'))

    }

    @Override
    int createAccount(double initialBalance) {
        String sql = "insert into account(id, balance) values (?, ?)"
        Account account = new Account(id: nextId++, balance: initialBalance)
        jdbcTemplate.update(sql, account.id, account.balance)
        // return account.getId()
        account.id
    }

    @Override
    Account findAccountById(int id) {
        String sql = "select * from account where id=?"
        jdbcTemplate.queryForObject(sql, accountMapper as RowMapper<Account>, id)
    }

    @Override
    List<Account> findAllAccounts() {
        String sql = "select * from account"
        jdbcTemplate.query(sql, accountMapper as RowMapper<Account>)
    }

    @Override
    void updateAccount(Account account) {
        String sql = "update account set balance=? where id=?"
        jdbcTemplate.update(sql, account.balance, account.id)
    }

    @Override
    void deleteAccount(int id) {
        jdbcTemplate.update("delete from account where id=?", id)
    }
}
