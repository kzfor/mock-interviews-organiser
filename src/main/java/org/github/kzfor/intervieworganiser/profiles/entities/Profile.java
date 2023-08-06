package org.github.kzfor.intervieworganiser.profiles.entities;

import jakarta.persistence.*;
import org.github.kzfor.intervieworganiser.meeting.entities.Meeting;

import java.util.Set;

@Entity
@Table(schema = "mock_interviews", name = "profiles")
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String vkUrl;
    private String telegramUrl;
    @OneToMany
    private Set<Meeting> meetings;
}
