package com.cristian.portaria.project.dtos.request;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record UserAuthenticationRequest(
        @NotBlank(message = "O login é obrigatorio")
        String login,
        @NotBlank(message = "A senha é obrigatória")
        String password) {

}
