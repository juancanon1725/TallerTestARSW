package com.example.testing_web;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import co.edu.escuelaing.arsw.bbapp.BBUser;
import co.edu.escuelaing.arsw.bbapp.BBUserService;
import co.edu.escuelaing.arsw.bbapp.controllers.DrawingServiceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
public class DrawingServiceControllerTest {

    @Mock
    private BBUserService userRepository;

    @InjectMocks
    private DrawingServiceController drawingServiceController;

    private BBUser user;

    @BeforeEach
    public void setUp() {
        user = new BBUser();
        user.setName("testUser");
    }

    @Test
    public void loadUserByUsername_UserExists_ReturnsUserDetails() {
        when(userRepository.findByName("testUser")).thenReturn(user);

        UserDetails userDetails = drawingServiceController.loadUserByUsername("testUser");

        assertNotNull(userDetails);
        assertEquals("testUser", userDetails.getUsername());
        assertFalse(userDetails.getAuthorities().isEmpty());
    }

    @Test
    public void loadUserByUsername_UserDoesNotExist_ThrowsException() {
        when(userRepository.findByName("unknownUser")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            drawingServiceController.loadUserByUsername("unknownUser");
        });
    }
}

