package com.switchfully.jeremie.eurder.exceptions;

public class NullChecker {
    public static <T> void checkArgumentForNull(T argumentToCheck){
        if(argumentToCheck == null) throw new IllegalArgumentException("Argument can't be null!");
    }
}
