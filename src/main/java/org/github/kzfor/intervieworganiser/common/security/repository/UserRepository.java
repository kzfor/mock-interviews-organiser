package org.github.kzfor.intervieworganiser.common.security.repository;

import org.github.kzfor.intervieworganiser.common.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
