package com.myfirstweb.Controller;

import com.myfirstweb.Entity.LineItem;
import com.myfirstweb.Entity.Product;
import com.myfirstweb.Entity.User;
import com.myfirstweb.SecurityService.SecurityService;
import com.myfirstweb.Service.LineItemService;
import com.myfirstweb.Service.ProductService;
import com.myfirstweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductDetails {

    @Autowired
    private SecurityService securityService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private LineItemService lineItemService;

    @GetMapping(value = "productDetails/{id}")
    public String getProductDetails(@PathVariable long id, ModelMap modelMap) {
        User myUser = securityService.getCurrentObjectUser();

        if (myUser.getCurrentOrder().findProductById(id))
            modelMap.put("haveOne", true);
        else
            modelMap.put("haveOne", false);

        modelMap.put("product", productService.getProductById(id));
        modelMap.put("user", myUser);
        modelMap.put("isLogged",true);
        return "product";
    }


    @PostMapping(value = "productDetails/post/{id}")
    public String putProductInOrder(@PathVariable long id, @ModelAttribute("product") Product product) {

        User myUser = securityService.getCurrentObjectUser();
        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItemService.insert(lineItem);
        myUser.getCurrentOrder().addLineItem(lineItem);
        userService.updateUser(myUser);

        return "redirect:/productDetails/" + id;
    }
}
