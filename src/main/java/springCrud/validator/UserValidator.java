package springCrud.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import springCrud.model.User;
import springCrud.service.UserService;

public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (userService.findUserByName(user.getName()) != null) {
            errors.rejectValue("username","User found in base");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "Required");
    }
}
