package com.myfirstweb.SecurityService;

import com.myfirstweb.Entity.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SecurityService {
    String getLoggedInUserName();
    void logout(HttpServletRequest request, HttpServletResponse response);
    ModelAndView autologin(String username, String password);
    User getCurrentObjectUser();
}
