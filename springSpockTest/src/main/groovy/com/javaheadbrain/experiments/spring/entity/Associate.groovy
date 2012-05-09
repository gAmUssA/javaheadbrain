package com.javaheadbrain.experiments.spring.entity

import groovy.transform.ToString

/**
 * TODO
 *
 * @since 5/2/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 *
 */

@ToString
class Associate {
    Integer id;
    String associateName;
    Integer companyId;
    Company company;
}
