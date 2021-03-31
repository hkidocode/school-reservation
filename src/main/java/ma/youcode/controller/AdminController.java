package ma.youcode.controller;

import ma.youcode.model.ReservationType;
import ma.youcode.model.Room;
import ma.youcode.model.User;
import ma.youcode.service.AdminService;
import ma.youcode.service.RoomService;
import ma.youcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userService.getAllNonEnableAndInactiveUsers());
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
        user.setActived(false);
        return "redirect:/dashboard";
    }

    @PostMapping("/dashboard/insertRoom")
    public String insertRoom(@RequestParam(value = "date") Date date,
                                @RequestParam(value = "users-num") int usersNum,
                                    @RequestParam(value = "contains-event", required = false) String containsEvent) {

        if (containsEvent != null) {
            roomService.addRoom(new Room(usersNum, date, true));
        } else {
            roomService.addRoom(new Room(usersNum, date));
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard/search")
    public String searchByDate(@RequestParam String date, Model model) {
        model.addAttribute("allReservationsInRoom", adminService.getAllReservationInRoom(Date.valueOf(date)));
        return "redirect:/dashboard";
    }

}
