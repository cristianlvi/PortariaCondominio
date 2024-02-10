package com.cristian.portaria.project.dtos;

import com.cristian.portaria.project.role.Role;

public record UserRegisterRequest(
        String login,
        String password,
        Role role
) {
}
