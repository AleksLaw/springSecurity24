package springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import springCrud.model.Role;
import springCrud.model.User;
import springCrud.service.RoleService;
import springCrud.service.UserService;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Autowired()
    private UserService userService;
    @Autowired()
    private RoleService roleService;


    @GetMapping("/admin/adminPageInfo")
    public ModelAndView listUsers() {
        List<User> list = userService.allUser();
        ModelAndView modelAndView = new ModelAndView("adminPageInfo");
        modelAndView.getModelMap().addAttribute("listUsers", list);
        return modelAndView;
    }

    @PostMapping("/admin/addUser")
    public String addUser(User user, @RequestParam("role") String role) {
        Set<Role> userRoles = getRoles(role);
        User userNew = new User();
        userNew.setUserRoles(userRoles);
        userNew.setName(user.getName());
        userNew.setPassword(user.getPassword());

        userService.addUser(userNew);
        return "redirect:/admin/adminPageInfo";
    }

    private Set<Role> getRoles(@RequestParam("role") String role) {
        Set<Role> userRoles = new HashSet<>();
        String[] split = role.split(",");
        for (String s : split) {
            Long roleIdByName = roleService.getRoleIdByName(s);
            Role roleById = roleService.getRoleById(roleIdByName);
            userRoles.add(roleById);
        }
        return userRoles;
    }

    @GetMapping("/admin/addUserPage")
    public String addUserPage() {
        return "addUserPage";
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

    @PostMapping("/admin/editUser")
    public ModelAndView viewEditPage(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        List<User> list = new ArrayList<>();
        list.add(user);
        ModelAndView modelAndView = new ModelAndView("editUser");
        modelAndView.getModelMap().addAttribute("listUsers", list);
        return modelAndView;
    }

    @PostMapping("/admin/updateUser")
    public String updateUser(User user, @RequestParam("role") String role) {
    // String rr = role;
        Set<Role> userRoles = getRoles(role);
        user.setUserRoles(userRoles);
//        User userOld = userService.getUserById(id);
//        userOld.setPassword(user.getPassword());
//        userOld.setName(user.getName());
//        userOld.setUserRoles(userRoles);
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
