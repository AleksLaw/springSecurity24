package springCrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springCrud.model.User;
import springCrud.service.SecurityService;
import springCrud.service.UserService;
import springCrud.validator.UserValidator;
import sun.awt.ModalExclude;

public class UserControllerSecurity {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getName(), userForm.getPassword());
        return "registration";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Login or password incorrect");
        }
        if (logout != null) {
            model.addAttribute("messages", "Logout success");
        }
        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String velcome(Model model) {
        return "welcome";
    }

    @GetMapping("admin")
    public String admin(Model model) {
        return "admin";
    }
}
