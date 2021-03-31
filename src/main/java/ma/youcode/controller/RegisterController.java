package ma.youcode.controller;

import ma.youcode.model.User;
import ma.youcode.model.UserRole;
import ma.youcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String home() {
        return "home-register";
    }

    @PostMapping("/register/processRegister")
    public String processRegister(@RequestParam("f-name") String name,
                                  @RequestParam String phone,
                                  @RequestParam String email,
                                  @RequestParam String password,
                                  Model model) {

        User user = new User(name, phone, email, password, UserRole.USER);
        // check the database if user already exists
        User existing = userService.findByEmail(email);
        if (existing != null) {
            model.addAttribute("registrationError", "L'addresse mail déja existe!");
            return "home-register";
        }
        userService.addUser(user);
        return "home-signin";
    }
}