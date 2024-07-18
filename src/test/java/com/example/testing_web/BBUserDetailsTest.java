package com.example.testing_web;

import co.edu.escuelaing.arsw.bbapp.BBUser;
import co.edu.escuelaing.arsw.bbapp.BBUserDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BBUserDetailsTest {

    private BBUser user;
    private Set<GrantedAuthority> authorities;
    private BBUserDetails userDetails;

    @BeforeEach
    void setUp() {
        user = new BBUser("testUser", "testPassword");
        authorities = Set.of(new SimpleGrantedAuthority("ROLE_USER"));
        userDetails = new BBUserDetails(user, authorities);
    }

    @Test
    void testGetPassword() {
        assertEquals("testPassword", userDetails.getPassword());
    }

    @Test
    void testGetUsername() {
        assertEquals("testUser", userDetails.getUsername());
    }

    @Test
    void testToString() {
        String expected = "BBUser [name=testUser, pass=testPassword]";
        assertEquals(expected, user.toString());
    }

}

