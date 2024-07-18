package com.example.testing_web;

import co.edu.escuelaing.arsw.bbapp.BBUser;
import co.edu.escuelaing.arsw.bbapp.BBUserService;
import co.edu.escuelaing.arsw.bbapp.controllers.BBUserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class BBUserControllerTest {

    @InjectMocks
    private BBUserController bbUserController;

    @Mock
    private BBUserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bbUserController).build();
    }

    @Test
    void testCreates() throws Exception {
        String username = "testUser";
        String password = "password123";

        // Mock the behavior of the userService
        BBUser user = new BBUser(username, password);
        when(userService.save(any(BBUser.class))).thenReturn(user);

        // Perform the POST request
        ResultActions result = mockMvc.perform(post("/creates")
                .param("usern", username)
                .param("password", password)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED));

        // Verify the response and behavior
        result.andExpect(status().isOk())
                .andExpect(view().name("home"));

        verify(userService, times(1)).save(any(BBUser.class));
    }
    @Test
    void testGetAllUsers() {
        BBUser user1 = new BBUser("user1", "pass1");
        BBUser user2 = new BBUser("user2", "pass2");
        List<BBUser> users = List.of(user1, user2);

        // Mock the behavior of the userService
        when(userService.findAll()).thenReturn(users);

        List<BBUser> result = bbUserController.getAllUsers();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("user1", result.get(0).getName());
        assertEquals("user2", result.get(1).getName());
    }

}

