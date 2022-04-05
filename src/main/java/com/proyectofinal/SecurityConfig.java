package com.proyectofinal;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Alejandro")
                .password("{noop}Pass")
                .roles("ADMINISTRADOR", "GESTION", "USUARIO")
                .and()
                .withUser("Ana")
                .password("{noop}Pass")
                .roles("GESTION", "USUARIO")
                .and()
                .withUser("Pepe")
                .password("{noop}Pass")
                .roles("USUARIO");
    }
}
