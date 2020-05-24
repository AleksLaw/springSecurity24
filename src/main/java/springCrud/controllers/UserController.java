package springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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


    @GetMapping("/admin/adminPageInfo")
    public ModelAndView listUsers() {
        List<User> list = userService.allUser();
        ModelAndView modelAndView = new ModelAndView("adminPageInfo");
        modelAndView.getModelMap().addAttribute("listUsers", list);
        return modelAndView;
    }

    @PostMapping("/admin/addUser")
    public String addUser(User user) {
        this.userService.addUser(user);
        return "redirect:/admin/adminPageInfo";
    }

    @PostMapping("/admin/delUser")
    public String delUser(@RequestParam("id") Long id) {
        this.userService.delUser(id);
        return "redirect:/admin/adminPageInfo";
    }
    @PostMapping("/admin/deleteUser")
    public ModelAndView viewDelPage(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        List<User> list = new ArrayList<>();
        list.add(user);
        ModelAndView modelAndView = new ModelAndView("deleteUser");
        modelAndView.getModelMap().addAttribute("listUsers", list);
        return modelAndView;
    }

    @PostMapping("/admin/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin/adminPageInfo";
    }

    @RequestMapping(value = "/userInfoPage", method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        List<User> list = getUsers();
        ModelAndView modelAndView = new ModelAndView("userInfoPage");
        modelAndView.getModelMap().addAttribute("listUsers", list);
        return modelAndView;

    }

    private List<User> getUsers() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Long userIdByName = userService.getUserIdByName(name);
        User user = userService.getUserById(userIdByName);
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }


}
