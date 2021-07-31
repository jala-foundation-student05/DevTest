package org.devtest.contactbackend.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(	name = "relations")
public class Relations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;
    private Integer contactId;
    private LocalDate acquaintanceDate;
    private String relation;


}
