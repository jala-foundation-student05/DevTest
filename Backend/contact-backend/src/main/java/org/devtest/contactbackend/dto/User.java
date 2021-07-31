package org.devtest.contactbackend.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
        })
public class User {
    @Id
    private String id;

    private String firstName;
    private String userName;


}
