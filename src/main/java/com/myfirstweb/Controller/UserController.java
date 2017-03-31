package com.myfirstweb.Controller;

import com.myfirstweb.Configuration.UserDto;
import com.myfirstweb.Configuration.UserValidator;
import com.myfirstweb.Entity.User;
import com.myfirstweb.SecurityService.SecurityService;
import com.myfirstweb.Service.LineItemService;
import com.myfirstweb.Service.OrderService;
import com.myfirstweb.Service.ProductService;
import com.myfirstweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        securityService.logout(request, response);
        return "redirect:/home";
    }

    @GetMapping(value = "/login")
    public String login(User user) {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration(UserDto userDto) {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) {
        userValidator.validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.register(userDto);
        return "successfullyReg";
    }




}
