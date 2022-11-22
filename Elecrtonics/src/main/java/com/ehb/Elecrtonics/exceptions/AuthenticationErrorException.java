package com.ehb.Elecrtonics.exceptions;

public class AuthenticationErrorException extends IllegalArgumentException{

    public AuthenticationErrorException(String s) {
        super(s);
    }
}
