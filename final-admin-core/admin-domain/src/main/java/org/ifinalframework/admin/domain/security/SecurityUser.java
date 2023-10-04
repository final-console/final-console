package org.ifinalframework.admin.domain.security;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.ifinalframework.core.lang.Transient;
import org.ifinalframework.admin.entity.core.User;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

/**
 * SecurityUser
 *
 * @author mik
 * @since 1.5.2
 **/
@Setter
@Getter
@Transient
public class SecurityUser extends User implements UserDetails, CredentialsContainer {

    private Collection<? extends GrantedAuthority> authorities;

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

    @Override
    public void eraseCredentials() {
        this.setPassword(null);
    }
}
