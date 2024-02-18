package com.cristian.portaria.project.controller;

import com.cristian.portaria.project.dtos.request.UserAuthenticationRequest;
import com.cristian.portaria.project.dtos.request.UserRegisterRequest;
import com.cristian.portaria.project.services.security.UserService;
import io.swagger.v3.oas.annotations.Operation;
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


    @Operation(summary = "Faz login na aplicação", method = "POST")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserAuthenticationRequest userRequest) {
        var userNamePassword = new UsernamePasswordAuthenticationToken(userRequest.login(), userRequest.password());
        var auth = authenticationManager.authenticate(userNamePassword);

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Registra um novo user", method = "POST")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterRequest registerRequest) throws Exception {
        UserRegisterRequest userRequest = userService.registerUser(registerRequest);

        return ResponseEntity.ok().body("Usuario registrado com sucesso");
    }


}
