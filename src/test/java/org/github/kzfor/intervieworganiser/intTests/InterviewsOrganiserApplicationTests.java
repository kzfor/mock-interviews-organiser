package org.github.kzfor.intervieworganiser.intTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

class InterviewsOrganiserApplicationTests extends AbstractIT {

    @Autowired
    UserDetailsService userDetailsService;

    @Test
    void contextLoads() {

        System.out.println(userDetailsService.getClass().getSimpleName());
    }

}
