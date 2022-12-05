package com.contactbook.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Integer idContact;

    @Column(name = "name_contact", nullable = false, length = 300)
    private String nameContact;

    @Column(name = "email_contact", nullable = false, length = 300)
    private String emailContact;

    @Column(name = "favorite_contact")
    private Boolean favoriteContact;

}