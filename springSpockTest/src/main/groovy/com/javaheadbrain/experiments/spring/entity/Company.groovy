package com.javaheadbrain.experiments.spring.entity

import groovy.transform.ToString

/**
 * TODO
 *
 * @since 5/2/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 */
@ToString
class Company {
    Integer id;
    String companyName;
    List<Associate> associates;
}
