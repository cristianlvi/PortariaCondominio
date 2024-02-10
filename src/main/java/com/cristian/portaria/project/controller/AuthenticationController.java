package com.cristian.portaria.project.controller;

import com.cristian.portaria.project.dtos.UserAuthenticationRequest;
import com.cristian.portaria.project.dtos.UserRegisterRequest;
import com.cristian.portaria.project.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserAuthenticationRequest userRequest) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(userRequest.login(), userRequest.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRegisterRequest registerRequest) throws Exception {
        UserRegisterRequest userRequest = userService.registerUser(registerRequest);

        return ResponseEntity.ok().body("Usuario registrado com sucesso");
    }


}
