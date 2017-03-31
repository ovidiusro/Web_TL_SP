package com.myfirstweb.Controller;

import com.myfirstweb.Entity.LineItem;
import com.myfirstweb.Entity.User;
import com.myfirstweb.SecurityService.SecurityService;
import com.myfirstweb.Service.LineItemService;
import com.myfirstweb.Service.ProductService;
import com.myfirstweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class PageController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private LineItemService lineItemService;

    @GetMapping(value = "/home")
    public String getHome(Model homeModel, Principal principal) {
        User myUser = securityService.getCurrentObjectUser();

        if (principal == null)
            homeModel.addAttribute("isLogged", false);
        else {
            homeModel.addAttribute("isLogged", true);
            homeModel.addAttribute("user", myUser);
        }
        homeModel.addAttribute("allProducts", productService.getAllProducts());
        return "home";
    }

    @GetMapping(value = "/home/addToCart/{id}")
    public String addtoCart(@PathVariable long id, ModelMap modelMap) {
        User myUser = securityService.getCurrentObjectUser();

        if (! myUser.getCurrentOrder().findProductById(id)) {
            LineItem lineItem = new LineItem();
            lineItem.setProduct(productService.getProductById(id));
            lineItemService.insert(lineItem);
            myUser.getCurrentOrder().addLineItem(lineItem);//incearca sa il stergi
            userService.updateUser(myUser);
        }

        return "redirect:/home";
    }

    @GetMapping
    public String handleNothing() {
        return "redirect:/home";
    }

}
