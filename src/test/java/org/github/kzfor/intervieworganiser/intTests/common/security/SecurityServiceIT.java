package org.github.kzfor.intervieworganiser.intTests.common.security;

import org.github.kzfor.intervieworganiser.common.security.SecurityPort;
import org.github.kzfor.intervieworganiser.common.security.repository.UserRepository;
import org.github.kzfor.intervieworganiser.intTests.AbstractIT;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SecurityServiceIT extends AbstractIT {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityPort securityPort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void should_create_new_user() {
        var username = "testUserName";
        var password = "testPassword";

        // when
        securityPort.createUser(username, password);

        // then
        var userInDb = userRepository.findByUsername(username);

        assertNotNull(userInDb, "User is expected to be in the DB, but null provided");
        assertNotEquals(password, userInDb.getPassword(), "Found original password in DB. It should be encoded.");
        assertTrue(passwordEncoder.matches(password, userInDb.getPassword()), "Password should be decoded correctly.");
    }
}
