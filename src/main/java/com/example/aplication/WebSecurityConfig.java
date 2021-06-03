package com.example.aplication;

import javax.sql.DataSource;

import com.example.aplication.util.LoginSuccessMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
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

        builder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passEncoder)
                .usersByUsernameQuery("SELECT username, password, u.enabled FROM user u inner join persona p on u.id = p.id where username =?")
                .authoritiesByUsernameQuery(
                        "Select u.username, r.tipo FROM role r inner join user u on r.id=u.role_id where u.username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Configuracion de http para acceso publico
        // http.authorizeRequests().antMatchers("/", "/home", "/index", "/css/**",
        // "/js/**", "/images/**").permitAll().anyRequest().authenticated();  
        http
            .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/buscar/permiso").access("not(hasRole('ADMIN'))")
                .antMatchers(HttpMethod.GET,"/buscar/permisoRodado").access("hasRole('AUDITOR')")

                .antMatchers("/", "/home", "/index", "/css/**", "/js/**", "/images/**","/permiso/**", "/rodados/**").permitAll().anyRequest()
        
                .authenticated().and().formLogin()
        .successHandler(loginSuccess)
        .loginPage("/login")
        .permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
        
      
        //http.authorizeRequests().antMatchers("/", "/home", "/index", "/css/**", "/js/**", "/images/**","/views/users/").hasAnyRole("ADMIN").anyRequest()
        //.authenticated();

    }

}
