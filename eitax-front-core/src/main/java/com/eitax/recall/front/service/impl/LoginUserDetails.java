package com.eitax.recall.front.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class LoginUserDetails extends User {
	private String username;
	
    private static final List<? extends GrantedAuthority> DEFAULT_AUTHORITIES = Collections
            .singletonList(new SimpleGrantedAuthority("ROLE_USER"));

    public LoginUserDetails(String username,List<GrantedAuthority> authorities){
        super(username,
                "dust", true, true, true, true, authorities); // (4)
        this.username = username;
    }

    
/*            
    public LoginUserDetails(User user) {
        super(user.getUsername(),
                null, true, true, true, true, DEFAULT_AUTHORITIES); // (4)
        
//        super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
//      super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }
    */
//    public LoginUserDetails(User user) {
//        super(user.getUsername(), user.getEncodedPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
//        this.user = user;
//    }
}
