package com.cristian.portaria.project.dtos.request;

public record UserAuthenticationRequest(
        String login,
        String password) {

}
