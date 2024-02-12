package com.cristian.portaria.project.services.impl;

import com.cristian.portaria.project.dtos.request.VisitanteRequest;
import com.cristian.portaria.project.dtos.response.VisitanteResponse;
import com.cristian.portaria.project.services.VisitanteService;
import org.springframework.stereotype.Service;

@Service
public class VisitanteServiceImpl implements VisitanteService {
    @Override
    public VisitanteResponse addVisitante(VisitanteRequest visitanteRequest) {
        return null;
    }

    @Override
    public VisitanteResponse buscaVisitantePeloCpf(String cpf) {
        return null;
    }

    @Override
    public void verificaVisitante(String cpf) {

    }
}
