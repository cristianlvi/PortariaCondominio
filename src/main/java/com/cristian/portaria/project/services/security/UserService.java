package com.cristian.portaria.project.services.security;

import com.cristian.portaria.project.domain.morador.User;
import com.cristian.portaria.project.dtos.request.UserAuthenticationRequest;
import com.cristian.portaria.project.dtos.request.UserRegisterRequest;
import com.cristian.portaria.project.exception.custons.UserException;
import com.cristian.portaria.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserRegisterRequest registerUser(UserRegisterRequest registerRequest) throws UserException {
        if (this.userRepository.findByLogin(registerRequest.login()) != null) {
            throw new UserException("User já existe");
        }
        String senhaHash = new BCryptPasswordEncoder().encode(registerRequest.password());

        User user = new User(registerRequest.login(), senhaHash, registerRequest.role());
        userRepository.save(user);

        return registerRequest;
    }


    public boolean checkAutenticationUser(UserAuthenticationRequest request) {
        UserDetails user = userRepository.findByLogin(request.login());

        if (user != null) {
            String passwordLogin = user.getPassword().toString();

            String senhaRequest = new BCryptPasswordEncoder().encode(request.password());

            return passwordEncoder().matches(passwordLogin, senhaRequest);
        }

        return false;
    }


    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
