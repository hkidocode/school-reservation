package ma.youcode.controller;

import ma.youcode.model.User;
import ma.youcode.model.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

//    UserService userService = new UserService();

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/home")
    public String register(HttpServletRequest request) {
        User user = new User(request.getParameter("f-name"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("password"), UserRole.USER);
//        userService.signUpUser(user);
        return "home";
    }
}