package com.myfirstweb.Controller;

import com.myfirstweb.SecurityService.SecurityService;
import com.myfirstweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    @Autowired
    SecurityService securityService;
    @Autowired
    UserService userService;

    private com.myfirstweb.Entity.User myUser;


    @GetMapping(value = "/cart")
    public String displayUserCart( Model model)
    {
       myUser = securityService.getCurrentObjectUser();

        model.addAttribute("LineItems",  myUser.getCurrentOrder().getLineItems()) ;
        model.addAttribute("isLogged", true);
        model.addAttribute("user",myUser);
        return "cart";
    }


    @PostMapping(value = "/cart/remove/{id}")
    public String deleteItemFromCart(@PathVariable long id )
    {
        myUser = securityService.getCurrentObjectUser();

        myUser.getCurrentOrder().deleteProductById(id);
        userService.updateUser(myUser);
        return "redirect:/cart";
    }
}
