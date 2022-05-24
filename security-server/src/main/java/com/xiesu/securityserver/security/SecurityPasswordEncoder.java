package com.xiesu.securityserver.security;

import java.nio.charset.StandardCharsets;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author xiesu
 */
@Component
public class SecurityPasswordEncoder implements PasswordEncoder {


    /**
     * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or greater hash
     * combined with an 8-byte or greater randomly generated salt.
     *
     * @param rawPassword
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Encoder.encode(rawPassword.toString().getBytes(StandardCharsets.UTF_8));

    }

    /**
     * Verify the encoded password obtained from storage matches the submitted raw password after it
     * too is encoded. Returns true if the passwords match, false if they do not. The stored
     * password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from storage
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return encode(rawPassword).equals(encodedPassword);
    }
}
