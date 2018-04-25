package com.servis.event.controller;

import com.servis.event.model.Role;
import com.servis.event.model.User;
import com.servis.event.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView createNewUser() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView modelAndView(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userByEmail = userService.findByEmail(user.getEmail());
        if (userByEmail != null) {
            bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            Role role = new Role("ADMIN");
            Set<Role> set = new HashSet<>();
            set.add(role);
            user.setRoles(set);
            userService.save(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }

    @PostMapping("/events")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userByEmail = userService.findByEmail(authentication.getName());
        modelAndView.addObject("name", "Welcome " + userByEmail.getName() + " " + userByEmail.getEmail());
        modelAndView.addObject("adminMessage", "Content available only for users with admin role");
        modelAndView.setViewName("events");
        return modelAndView;
    }
}
