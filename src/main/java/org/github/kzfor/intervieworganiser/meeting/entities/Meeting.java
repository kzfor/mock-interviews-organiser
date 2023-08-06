package org.github.kzfor.intervieworganiser.meeting.entities;

import jakarta.persistence.*;
import org.github.kzfor.intervieworganiser.profiles.entities.Profile;

import java.time.LocalDateTime;

@Entity
@Table(schema = "mock_interviews", name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Profile organizer;
    private String topic;
    private LocalDateTime createdAt;
    private LocalDateTime scheduled;


}
