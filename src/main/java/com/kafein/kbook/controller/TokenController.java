package com.kafein.kbook.controller;

import com.kafein.kbook.dto.LoginRequest;
import com.kafein.kbook.dto.TokenResponse;
import com.kafein.kbook.dto.UserDTO;
import com.kafein.kbook.model.User;
import com.kafein.kbook.repository.UserRepository;
import com.kafein.kbook.security.JwtTokenUtil;
import com.kafein.kbook.service.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/kbook/token")
@RestController
public class TokenController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<TokenResponse> getToken(@RequestBody LoginRequest request) throws AuthenticationServiceException{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User theUser = userService.findByUsername(request.getUsername());
        String token = jwtTokenUtil.generateToken(theUser);
        return ResponseEntity.ok(new TokenResponse(theUser.getUsername(), token));
    }

}
