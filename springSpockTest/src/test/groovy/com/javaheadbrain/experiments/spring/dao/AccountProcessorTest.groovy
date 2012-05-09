package com.javaheadbrain.experiments.spring.dao

import com.javaheadbrain.experiments.spring.entity.Account
import com.javaheadbrain.experiments.spring.service.AccountProcessor
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import javax.inject.Inject
import javax.inject.Named

/**
 * TODO
 *
 * @since 5/2/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 */

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class AccountProcessorTest extends Specification {
    @Inject
    AccountProcessor accountProcessor

    @Inject
    @Named("myBatisAccountDAO")
    AccountDAO dao

    def "processing test accounts should yield 3 "() {
        given:
        def accounts = dao.findAllAccounts()
        when:
        def result = accountProcessor.processAccounts()
        then:
        result == 3.0
        accounts.each {Account account ->
            account.balance.toString().endsWith "9"
        }
    }

}
