package com.cristian.portaria.project.dtos.request;

import com.cristian.portaria.project.role.Role;

public record UserRegisterRequest(
        String login,
        String password,
        Role role
) {
}
