package com.myfirstweb.Service;

import com.myfirstweb.Configuration.UserDto;
import com.myfirstweb.Entity.User;

public interface UserService {
    void insertUser(User user);
    void updateUser(User user);
    User getUserByUsername(String username);
    User register(UserDto userDto);
}
