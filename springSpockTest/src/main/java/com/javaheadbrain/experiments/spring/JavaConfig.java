package com.javaheadbrain.experiments.spring;

import com.javaheadbrain.experiments.spring.dao.AccountDAO;
import com.javaheadbrain.experiments.spring.service.AccountProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 5/1/12
 */
@Configuration
public class JavaConfig {
    @Inject
    @Named("jdbcAccountDAO")
    private AccountDAO accountDAO;

    @Bean
    public AccountProcessor accountProcessor() {
        AccountProcessor ap = new AccountProcessor();
        ap.setAccounts(accountDAO.findAllAccounts());
        return ap;
    }
}
