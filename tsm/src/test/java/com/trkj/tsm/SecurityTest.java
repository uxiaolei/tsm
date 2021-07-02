package com.trkj.tsm;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Log4j2
public class SecurityTest {
    @Test
    public void testPw(){
//        PasswordEncoder pw=new BCryptPasswordEncoder();
//        String encoder=pw.encode("12345");
//        log.debug(encoder);
//        boolean matches=pw.matches("12345",encoder);
//        log.debug(matches);
    }
}
