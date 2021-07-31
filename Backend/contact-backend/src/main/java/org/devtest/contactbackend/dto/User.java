package org.devtest.contactbackend.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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

    //Relations

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "relations_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "relations_id"))
    private Set<Relations> relations;


}
