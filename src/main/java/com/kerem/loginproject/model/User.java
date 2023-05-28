package com.kerem.loginproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    @NotEmpty(message = "* Please provide a username")
    private String firstName;
    @Column(name = "last_name")
    @NotEmpty(message = "* Please provide a username")
    private String lastName;
    @Column(name = "user_name")
    @Length(min = 5, message = "Your password must be at least 5 characters")
    @NotEmpty(message = "* Please provide a username")
    private String userName;
    @Column(name = "password")
    @Length(min = 5, message = "Your password must be at least 5 characters")
    @NotEmpty(message = "* Please provide a password")
    private String password;
    @Column(name = "email")
    @Email(message = "Please enter a valid email")
    @NotEmpty(message = "Please provide an email")
    private String email;
    @Column(name = "active")
    private Boolean active;
    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
