package org.ifinalframework.console.sso.domain.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.ifinalframework.data.query.Query;
import org.ifinalframework.console.sso.domain.security.SecurityUser;
import org.ifinalframework.console.sso.entity.User;
import org.ifinalframework.console.sso.repository.mapper.UserMapper;
import org.ifinalframework.console.sso.repository.query.QUser;

import jakarta.annotation.Resource;

import java.util.Arrays;
import java.util.Objects;

/**
 * UserDetailsServiceImpl
 *
 * @author mik
 * @since 1.5.2
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userMapper.selectOne(new Query().where(QUser.username.eq(username)));

        if(Objects.isNull(user)){
            return null;
        }

        final SecurityUser securityUser = new SecurityUser();
        BeanUtils.copyProperties(user, securityUser);
        securityUser.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_ROOT")));



        return securityUser;
    }
}
