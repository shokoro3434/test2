package com.eitax.recall.front.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginUserDetailsService {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
