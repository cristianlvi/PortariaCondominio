package com.cristian.portaria.project.services.security;

import com.cristian.portaria.project.domain.morador.User;
import com.cristian.portaria.project.dtos.request.UserRegisterRequest;
import com.cristian.portaria.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserRegisterRequest registerUser(UserRegisterRequest registerRequest) throws Exception {
        if (this.userRepository.findByLogin(registerRequest.login()) != null) {
            throw new Exception("User já existe");
        }

        String senhaHash = new BCryptPasswordEncoder().encode(registerRequest.password());
        User user = new User(registerRequest.login(), senhaHash, registerRequest.role());
        userRepository.save(user);

        return registerRequest;
    }

}
