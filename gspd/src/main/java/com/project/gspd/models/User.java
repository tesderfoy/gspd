package com.project.gspd.models;

import com.project.gspd.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private  Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "login", unique = true)
    private  String login;
    @Column(name = "password")
    private String password;
    @ElementCollection(targetClass = Role.class, fetch =  FetchType.EAGER)
    @CollectionTable(name = "user_role",
            joinColumns = @JoinColumn(name ="user_id" ))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}