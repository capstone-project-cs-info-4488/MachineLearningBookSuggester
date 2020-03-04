package edu.isu.capstone.bookrec.backend.hibernate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Entity
public class UserDetailsImpl extends BaseEntity implements UserDetails, Serializable {

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    private String username;
    private String password;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    private Set<Roles> roles;

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
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

    public UserDetailsImpl() {

    }

    public UserDetailsImpl(@NotNull User user) {
        this.user = user;
    }

    public void grantAuthority(@NonNull Roles authority) {
        if (roles == null) { roles = new HashSet<>(); }
        roles.add(authority);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final String PREFIX = "ROLE_";
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(PREFIX.concat(role.toString())));
        });
        return authorities;
    }
}
