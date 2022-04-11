package com.proyectofinal;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("alejandro")
                    .password("{noop}123")
                    .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("esteban")
                    .password("{noop}123")
                    .roles("VENDEDOR","USER")
                .and()
                .withUser("pepe")
                    .password("{noop}123")
                    .roles("USER");
    }
    
     @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/colecionismo/principal", "/infantil/principal","/periferico/principal","/retro/principal","/other/mapa")
                    .hasRole("ADMIN")
                .antMatchers("/colecionismo/principal", "/infantil/principal","/periferico/principal","/retro/principal","/other/mapa")
                    .hasAnyRole("ADMIN","VENDEDOR")
                .antMatchers("/")
                    .hasAnyRole("USER","VENDEDOR","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    } 
}
