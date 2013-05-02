package com.javaheadbrain.experiments

/**
 * TODO
 *
 * @since 7/11/12
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 */
class Mess {

    public boolean contains(String string1) {
        if (string1.equals("no-args")) return true;
        if (string1.equals("xyzzyz")) return false;
        if (string1.equals("No-Args")) return true;
        return false;
    }
}
