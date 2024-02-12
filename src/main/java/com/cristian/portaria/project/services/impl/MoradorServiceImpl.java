package com.cristian.portaria.project.services.impl;

import com.cristian.portaria.project.dtos.request.MoradorRequest;
import com.cristian.portaria.project.dtos.response.MoradorResponse;
import com.cristian.portaria.project.repositories.ApartamentoRepository;
import com.cristian.portaria.project.repositories.MoradorRepository;
import com.cristian.portaria.project.services.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoradorServiceImpl implements MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;
    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Override
    public MoradorResponse addMorador(MoradorRequest moradorRequest) {
        return null;
    }

    @Override
    public MoradorResponse atualizaMorador(MoradorRequest moradorRequest) {
        return null;
    }

    @Override
    public MoradorResponse apagaMorador(String cpf) {
        return null;
    }

    @Override
    public MoradorResponse buscaMoradorPeloApartamento(int numeroApartamento) {
        return null;
    }

    @Override
    public void verificaMoradorId(int id) {

    }
}
