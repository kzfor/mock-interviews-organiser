package org.github.kzfor.intervieworganiser.common.security.entities;

import jakarta.persistence.*;
import org.github.kzfor.intervieworganiser.profiles.entities.Profile;

@Entity
@Table(schema = "mock_interviews_security", name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private Boolean isEnabled;
    @OneToOne(
            targetEntity = Profile.class,
            fetch = FetchType.EAGER
    )
    private Profile profile;

    public User(String username, String password, String roles, Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public Boolean getAccountNonExpired() {
        return isAccountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public Profile getProfile() {
        return profile;
    }
}
