package com.myfirstweb.DataBaseSeeder;

import com.myfirstweb.Entity.*;
import com.myfirstweb.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private LineItemService lineItemService;
    @Autowired
    private ProductService productService;

    public void run(String... strings) throws Exception {

        roleService.insertRole(new Role("ROLE_ADMIN"));
        roleService.insertRole(new Role("ROLE_USER"));


        productService.insertProduct(new Product( "pic1", 6,"http://finemodernart.com/paintings/4134-kiss.jpg",10));
        productService.insertProduct(new Product( "pic2", 3," https://s-media-cache-ak0.pinimg.com/originals/00/4e/2a/004e2aa343b63e80de2e70e842a45f44.jpg",  50));
        productService.insertProduct(new Product( "pic3", (float)1.5, "http://i6.download.fd.pchome.net/g1/M00/07/05/ooYBAFMm03-IRcJ5AAcb6G_zB_sAABaSgLtVxEABxwA864.jpg",  0));
        productService.insertProduct(new Product("pic4", (float)2.55, "http://www.thenewyorkoptimist.com/images/MelissaAyr8.jpg",  15));
        productService.insertProduct(new Product( "pic5", (float)4.99, "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSrYyBTCx7wrr1RL6Pm0XVS4lLRbLuxvWjl7Ef7G6EXZNWk6c9_",  100));
        productService.insertProduct(new Product( "pic7", (float)4.99, "http://i.imgur.com/1wYVzIK.jpg",  90));
        productService.insertProduct(new Product( "pic8", (float)4.99, "http://artsatthearmory.org/wp-content/uploads/2016/02/Art.jpg",  90));


        userService.insertUser(new User("ovidiu","ovi"));
        userService.insertUser(new User("beni","beni"));
        userService.insertUser(new User("dan","dan"));

        List<Product> products =  new ArrayList<>(productService.getAllProducts());
        Orderr orderr1 = new Orderr();
        Orderr orderr2 = new Orderr();

        orderService.insertOrder(orderr1);
        orderService.insertOrder(orderr2);

        LineItem item1 = new LineItem();
        LineItem item2 = new LineItem();
        LineItem item3 = new LineItem();

        item1.setProduct(products.get(1));
        lineItemService.insert(item1);
        item2.setProduct(products.get(2));
        lineItemService.insert(item2);
        item3.setProduct(products.get(3));
        lineItemService.insert(item3);

        orderr2.addLineItem(item2);
        orderr2.addLineItem(item3);
        orderr1.addLineItem(item1);

        User user = userService.getUserByUsername("ovidiu");
        user.addOrder(orderr2);
        user.addOrder(orderr1);
        userService.updateUser(user);

    }

}
