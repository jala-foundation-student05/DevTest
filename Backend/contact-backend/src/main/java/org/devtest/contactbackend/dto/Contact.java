package org.devtest.contactbackend.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(	name = "contacts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
        })
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private LocalDate dateOfBirth;
    private String seed;

    //Relations

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "relations_contacts",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "relations_id"))
    private Set<Relations> relations;

}
