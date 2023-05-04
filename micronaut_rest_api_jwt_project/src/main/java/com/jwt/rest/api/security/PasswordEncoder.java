package com.jwt.rest.api.security;

import org.mindrot.jbcrypt.BCrypt;


public class PasswordEncoder {

    public static String encode(CharSequence rawPassword) {
        return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt());
    }

    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }

}
