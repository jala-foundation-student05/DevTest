package org.devtest.contactbackend.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

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
}
