package com.cristian.portaria.project.dtos;

public record UserAuthenticationRequest(
        String login,
        String password) {

}
