package com.example.csrex.user.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_user")
public class User {
    @Id
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @Column
    private Long age;
}
