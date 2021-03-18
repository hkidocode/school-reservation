package ma.youcode.controller;

import ma.youcode.model.User;
import ma.youcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userService.getAllNonEnableUsers());
        return "dashboard";
    }

    @GetMapping("/dashboard/accept")
    public String acceptUser(@RequestParam Long userId) {
        User user = userService.getUser(userId);
        userService.enableUser(user);
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard/delete")
    public String deleteUser(@RequestParam Long userId) {
        User user = userService.getUser(userId);
        userService.deleteUser(user);
        return "redirect:/dashboard";
    }

}
