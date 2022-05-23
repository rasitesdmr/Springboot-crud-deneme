package com.example.springbootcruddeneme.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , unique = true)
    private Long id;

    @Column(name = "first_name", length = 10)
    private String firstName;

    @Column(name = "last_name", length = 10)
    private String lastName;

    @Column(name = "email")
    private String email;
}
