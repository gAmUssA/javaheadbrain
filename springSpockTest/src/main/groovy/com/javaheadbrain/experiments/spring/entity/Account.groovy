package com.javaheadbrain.experiments.spring.entity

import groovy.transform.Canonical
import groovy.transform.ToString

/**
 * TODO
 *
 * @since 5/1/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 */

@ToString
@Canonical
class Account {
    Integer id
    Double balance

    double deposit(double amount) {
        // return keyword is optional
        balance += amount
    }

    double withdraw(double amount) {
        balance -= amount
    }
}
