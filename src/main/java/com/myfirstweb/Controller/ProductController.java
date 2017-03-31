package com.myfirstweb.Controller;
import com.myfirstweb.Entity.Product;
import com.myfirstweb.SecurityService.SecurityService;
import com.myfirstweb.Service.ProductService;
import com.myfirstweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;


    private com.myfirstweb.Entity.User myUser;


    @GetMapping()
    public String getAllProducts( Model modelMap) {
        modelMap.addAttribute("allProducts", productService.getAllProducts());
        return  "products";
    }


    //doar in back-end :D ....
    @DeleteMapping(value = "/delete/{id}")
    public void deleteProductById(@PathVariable long id) { productService.deleteProductById(id);
    }

    @PutMapping(value = "/update")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @GetMapping(value = "/insert")
    public String getFormInput(Model model) {
        model.addAttribute("product", new Product());
        return "input";
    }

    @PostMapping(value = "/insert")
    public String setFromInput(@ModelAttribute Product product) {
        productService.insertProduct(product);
        return "product";
    }
}
