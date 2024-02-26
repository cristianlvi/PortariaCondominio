package com.cristian.portaria.project.controller;

import com.cristian.portaria.project.domain.morador.User;
import com.cristian.portaria.project.dtos.request.UserAuthenticationRequest;
import com.cristian.portaria.project.dtos.request.UserRegisterRequest;
import com.cristian.portaria.project.exception.custons.AuthenticationException;
import com.cristian.portaria.project.exception.custons.UserException;
import com.cristian.portaria.project.repositories.UserRepository;
import com.cristian.portaria.project.services.security.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;


    @Operation(summary = "Registra novo User no API", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cria um novo User"),
            @ApiResponse(responseCode = "401", description = "User não criado"),
            @ApiResponse(responseCode = "403", description = "Não autorizado")
    })
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterRequest registerRequest) throws Exception {
        try {
            UserRegisterRequest userRequest = userService.registerUser(registerRequest);

            return ResponseEntity.ok().body("Usuario registrado com sucesso");
        } catch (UserException ex) {
            return ResponseEntity.status(403).body("Não autorizado");
        }
    }


    @Operation(summary = "Rota de login da aplicação", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "autenticação bem-sucedida"),
            @ApiResponse(responseCode = "401", description = "falha na autenticação"),
            @ApiResponse(responseCode = "403", description = "não autorizado")
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserAuthenticationRequest userRequest) {
        try {
            userService.checkAutenticationUser(userRequest);

            return ResponseEntity.status(200).body("autenticação bem-sucedida");
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body("Falha na autenticação " + ex.getMessage());
        }
    }


}
