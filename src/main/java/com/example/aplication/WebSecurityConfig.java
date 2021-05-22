package com.example.aplication;

import javax.sql.DataSource;

import com.example.aplication.util.LoginSuccessMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passEncoder;
    @Autowired
    private LoginSuccessMessage loginSuccess;

    @Autowired
    public void configurerSecurityGlobar(AuthenticationManagerBuilder builder) throws Exception {

        builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passEncoder)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users where username =?")
                .authoritiesByUsernameQuery(
                        "Select u.username, r.rol FROM roles r inner join users u on r.user_id=u.idusers where u.username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Configuracion de http para acceso publico
        // http.authorizeRequests().antMatchers("/", "/home", "/index", "/css/**",
        // "/js/**", "/images/**").permitAll().anyRequest().authenticated();
        http.authorizeRequests().antMatchers("/", "/home", "/index", "/css/**", "/js/**", "/images/**").permitAll().anyRequest()
        .authenticated().and().formLogin()
        .successHandler(loginSuccess)
        .loginPage("/login")
        .permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
        //http.authorizeRequests().antMatchers("/", "/home", "/index", "/css/**", "/js/**", "/images/**","/views/clientes/").hasAnyRole("ADMIN").anyRequest()
        //.authenticated();

    }

}
