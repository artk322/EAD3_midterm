package org.example.midterm.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private  String phoneNumber;

    @Column(name = "user_id")
    private Long user_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
