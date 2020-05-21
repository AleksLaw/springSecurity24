package springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springCrud.model.User;
import springCrud.service.UserService;

import java.util.List;

@Controller
@Transactional
public class UserController {
    @Autowired()
    private UserService userService;

    @GetMapping("/users")
    public ModelAndView listUsers() {
        List<User> list = userService.allUser();
        ModelAndView modelAndView = new ModelAndView("users");
//        model.addAttribute("listUsers", list);
        modelAndView.getModelMap().addAttribute("listUsers", list);  //addAttribute("listUsers", list);
        return modelAndView;
    }

    @PostMapping("/addUser")
    public String addUser(User user) { //@ModelAttribute("user")
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
        //  User userNew = user
        userService.updateUser(user);
        //    model.addAttribute("user", userNew);
        //    model.addAttribute("listUsers", this.userService.allUser());
        return "redirect:/users";
    }
}
