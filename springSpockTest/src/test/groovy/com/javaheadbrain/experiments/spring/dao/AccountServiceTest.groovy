package com.javaheadbrain.experiments.spring.dao

import com.javaheadbrain.experiments.spring.service.AccountService
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
class AccountServiceTest extends Specification {

    @Inject
    AccountService accountService

    def "injected service "() {
        expect: accountService
    }

    def "getAccountBalance test"() {
        expect:
        100.0 == accountService.getAccountBalance(0)
    }
}
