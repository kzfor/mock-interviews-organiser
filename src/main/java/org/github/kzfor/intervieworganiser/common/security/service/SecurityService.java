package org.github.kzfor.intervieworganiser.common.security.service;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.github.kzfor.intervieworganiser.common.security.SecurityPort;
import org.github.kzfor.intervieworganiser.common.security.entities.User;
import org.github.kzfor.intervieworganiser.common.security.repository.UserRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements SecurityPort {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public SecurityService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String username, String password) {
        var user = new User(
                username,
                passwordEncoder.encode(password),
                "ROLE_USER",
                true,
                true,
                true,
                true
        );
        userRepository.save(user);
    }
}
