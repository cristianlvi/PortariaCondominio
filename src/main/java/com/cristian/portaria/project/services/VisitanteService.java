package com.cristian.portaria.project.services;

import com.cristian.portaria.project.dtos.request.VisitanteRequest;
import com.cristian.portaria.project.dtos.response.VisitanteResponse;

public interface VisitanteService {

    VisitanteResponse addVisitante(VisitanteRequest visitanteRequest);

    VisitanteResponse buscaVisitantePeloCpf(String cpf);

    void verificaVisitante(String cpf);



}
