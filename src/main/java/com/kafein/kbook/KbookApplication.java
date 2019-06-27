package com.kafein.kbook;

import com.kafein.kbook.model.Role;
import com.kafein.kbook.model.User;
import com.kafein.kbook.repository.UserRepository;
import com.kafein.kbook.service.base.UserService;
import com.kafein.kbook.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import java.util.Arrays;

@SpringBootApplication
@EnableAuthorizationServer
@EnableScheduling
public class KbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(KbookApplication.class, args);
    }


    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
        builder.userDetailsService(s -> new CustomUserDetails(repo.findByUsername(s)));
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
