package springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springCrud.model.User;
import springCrud.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired()
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> list = userService.allUser();
        model.addAttribute("listUsers", list);
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          @ModelAttribute("user") User user) {
        Long userIdByName = this.userService.getUserIdByName(name, password);
        if (userIdByName == null) {
            this.userService.addUser(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/delUser")
    public String delUser(@RequestParam("id") Long id) {
        this.userService.delUser(id);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("password") String password,
                             @RequestParam("role") String role,
                             Model model
    ) {
        User userNew = new User(id, name, password, role);
        userService.addUser(userNew);
        model.addAttribute("user", userNew);
        model.addAttribute("listUsers", this.userService.allUser());
        return "redirect:/users";
    }
}
