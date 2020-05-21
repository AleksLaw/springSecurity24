package springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springCrud.model.User;
import springCrud.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired()
    private UserService userService;

    @GetMapping("/users")
    public ModelAndView listUsers() {
        List<User> list = userService.allUser();
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.getModelMap().addAttribute("listUsers", list);
        return modelAndView;
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        this.userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delUser")
    public String delUser(@RequestParam("id") Long id) {
        this.userService.delUser(id);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}
