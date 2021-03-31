package ma.youcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/signin")
    public String signin() {
        return "home-signin";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
