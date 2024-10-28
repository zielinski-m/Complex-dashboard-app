package com.melon.dashboard.controller;

import com.melon.dashboard.model.User;
import com.melon.dashboard.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/register")
    public String registerUser(User user, RedirectAttributes redirectAttributes) {
        // Sprawdzenie, czy email już istnieje
        if (userRepository.existsByEmail(user.getEmail())) {
            redirectAttributes.addFlashAttribute("error", "Email already in use.");
            return "redirect:/register";
        }

        // Haszowanie hasła przed zapisem
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        // Dodanie komunikatu o sukcesie
        redirectAttributes.addFlashAttribute("success", "Registration successful. Please log in");

        // Przekierowanie na stronę logowania
        return "redirect:/login";
    }
}
