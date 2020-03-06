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
@Getter
@Setter
public class UserDetailsImpl extends BaseEntity implements UserDetails, Serializable {

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;
    @NotNull
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    private Set<Roles> roles;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
