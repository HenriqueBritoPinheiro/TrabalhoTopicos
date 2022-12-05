package com.contactbook.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Integer idPerson;

    @Column(name = "name_person", nullable = false, length = 300)
    @NotEmpty()
    private String namePerson;

    @Column(name = "email_person", nullable = false, length = 300, unique = true)
    private String emailPerson;

    @Column(name = "password_person", nullable = false, length = 300)
    private String passwordPerson;

}