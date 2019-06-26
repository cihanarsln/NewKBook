package com.kafein.kbook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("password")).roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

                /*.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/kbook/admins/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll().anyRequest().authenticated();
                .and()
                .csrf().disable()
                .formLogin().disable(); */
    }


}