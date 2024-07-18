package co.edu.escuelaing.arsw.bbapp.controllers;

import java.util.List;

import co.edu.escuelaing.arsw.bbapp.BBUser;
import co.edu.escuelaing.arsw.bbapp.BBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class BBUserController {

    private final BBUserService userService;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public BBUserController(BBUserService userService) {
        this.userService = userService;
    }

    public BBUser createUser(BBUser customer) {
        return userService.save(customer);
    }

    public List<BBUser> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/creates")
    public String creates(String usern, String password, Model model) {

        String encodedPassword = passwordEncoder.encode(password);
        BBUser user = new BBUser(usern, encodedPassword);

        createUser(user);
        System.out.println("Created" + usern + " USER WITH " + encodedPassword + "PASSWORD");

        return "home";
    }


}
