/**
 * TODO
 *
 * @since 7/11/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 */
package com.javaheadbrain.experiments

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MessTest extends Specification {


    @Shared
    Mess messages = new Mess()

    @Unroll
    def "contains key: #desc"() {

        expect:

        messages.contains(key) == expectation

        where:

        key       | expectation | desc
        "no-args" | true        | "base case"
        "xyzzyz"  | false       | "key not present"
        "No-Args" | true        | "case insensitive"
    }
}
