package com.myfirstweb.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired // in clasa userdetails avem infromatile userului care incearca sa "loggeze"
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() { return new BCryptPasswordEncoder(); }


    @Autowired //realizam audentificarea
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());;
    }

    //securizeaza accesele
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/home","/registration", "/resources/**", "/bootstrap.css").permitAll() // permite accesul vizitatorilo
                    .anyRequest().authenticated() // interzice accesul vizitatorilor la toate celelalte requesturi
                    .and()
                .formLogin()// spring security are o pagina de login (by default) , iar noi ne definim propriul templates
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()//permitem logout pentru toate tipurile de utilizator
                    .permitAll()
                    .and()
               .httpBasic();
    }
}