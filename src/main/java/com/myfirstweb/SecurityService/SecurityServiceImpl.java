package com.myfirstweb.SecurityService;

import com.myfirstweb.Entity.User;
import com.myfirstweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service

public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;



    @Override
    public User getCurrentObjectUser()
    {
        return userService.getUserByUsername(getLoggedInUserName());
    }


    // returneaza username-ul sesiuni curente
    @Override
    public String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }


        System.out.println("Se apeleza automat dupa terminarea sesiuni");
        request.getSession().invalidate();//in case you put something in session
    }


    @Override
    public ModelAndView autologin(String username, String password) {
        /*ModelAndView modelAndView= new ModelAndView();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
             modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }

        modelAndView.setViewName("/registration");
        return modelAndView;
        */
        return null;
    }
}
