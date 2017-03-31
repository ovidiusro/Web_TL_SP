package com.myfirstweb.Service;

import com.myfirstweb.Configuration.UserDto;
import com.myfirstweb.Entity.LineItem;
import com.myfirstweb.Entity.Orderr;
import com.myfirstweb.Repository.RoleRepository;
import com.myfirstweb.Repository.UserRepository;
import com.myfirstweb.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LineItemService lineItemService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



   @Override
   public  void insertUser(User user)
   {
       user.setRoles(new ArrayList<>(roleRepository.findAll()));
       user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       userRepository.save(user);
   }
    @Override
    public  void updateUser(User user) { userRepository.save(user); }
    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User register(UserDto userDto)
    {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        insertUser(user);

        LineItem lineItem = new LineItem();
        lineItemService.insert(lineItem);
        Orderr orderr = new Orderr();
        orderService.insertOrder(orderr);
        orderr.addLineItem(lineItem);
        orderr.removeLineItem(lineItem);//doar sa se initializeze
        user.addOrder(orderr);

        updateUser(user);
        return  user;
    }
}
