package com.javaheadbrain.experiments.spring.dao

import com.javaheadbrain.experiments.spring.entity.Account
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import javax.inject.Inject

/**
 * TODO
 *
 * @since 5/1/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 */

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class JdbcAccountDAOTest extends Specification {

    @Inject
    JdbcAccountDAO dao

    def "dao is injected properly"() {
        expect: dao
    }

    def "find 3 accounts in sample db"() {
        expect: dao.findAllAccounts().size() == 3
    }

    def "find account 0 by id"() {
        when:
        Account account = dao.findAccountById(0)
        then:
        account.id == 0
        account.balance == 100.0
    }

    def "create account and find if"() {
        when:
        int newId = dao.createAccount(500.0)
        Account account = dao.findAccountById(newId);

        then:
        account.id == newId
        account.balance == 500.0

    }

    def "update account changes balance"() {
        given:
        Account account = dao.findAccountById(0)
        account.balance = 1000.0
        when:
        // method invocation
        dao.updateAccount account
        Account a = dao.findAccountById(0)
        then:
        a.balance == 1000.0

    }

    def "delete all accounts"() {
        when:
        dao.findAllAccounts().each {Account a ->
            dao.deleteAccount a.id
        }
        then:
        dao.findAllAccounts().size() == 0
    }

}
