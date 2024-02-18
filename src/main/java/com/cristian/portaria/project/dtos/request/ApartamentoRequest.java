package com.cristian.portaria.project.dtos.request;

import com.cristian.portaria.project.domain.apartamento.Situacao;
import jakarta.validation.constraints.Max;

public record ApartamentoRequest(

        String numero,

        @Max(10)
        int andar,

        Situacao situacao


) {
}
