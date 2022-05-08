package com.example.test.models;

import com.example.test.Enum.TypeSang;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification {

    @Id
    @SequenceGenerator(name = "notification_sequence", sequenceName = "notification_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_sequence")
    private int id;
    private String source;
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;
    private String address;
    private String beneficiary_name;
    private TypeSang type_sang ;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
