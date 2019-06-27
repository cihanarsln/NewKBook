package com.kafein.kbook.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User implements UserDetails, Serializable {

    @Id
    private String id;

    private String fname;

    private String lname;

    private String username;

    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    private String phone;

    private String address;

    private Date bdate;

    private String mail;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
