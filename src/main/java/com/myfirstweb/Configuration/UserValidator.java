package com.myfirstweb.Configuration;

import com.myfirstweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


//validarile pentru registrare
@Component
public class UserValidator implements Validator {


    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }


    @Override
    public void validate(Object o, Errors errors) {
        UserDto userDto = (UserDto) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (userDto.getUsername().length() < 3 || userDto.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userDto.username");
        }
        if (userService.getUserByUsername(userDto.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userDto.username");
        }

        if (userDto.getPassword().length() < 3 || userDto.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userDto.password");
        }
        if (!userDto.getPasswordConfirm().equals(userDto.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userDto.passwordConfirm");
        }
    }
}

