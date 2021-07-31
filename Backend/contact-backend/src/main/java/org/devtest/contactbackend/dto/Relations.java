package org.devtest.contactbackend.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(	name = "relations")
public class Relations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;
    private String contactId;
    private LocalDate acquaintanceDate;
    private String relation;

    //Relations

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(	name = "relations_user",
            joinColumns = @JoinColumn(name = "relations_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(	name = "relations_contact",
            joinColumns = @JoinColumn(name = "relations_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private Contact contact;


}
