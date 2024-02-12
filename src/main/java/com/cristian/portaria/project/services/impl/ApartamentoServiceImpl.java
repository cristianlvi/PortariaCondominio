package com.cristian.portaria.project.services.impl;

import com.cristian.portaria.project.dtos.request.ApartamentoRequest;
import com.cristian.portaria.project.dtos.response.ApartamentoResponse;
import com.cristian.portaria.project.repositories.ApartamentoRepository;
import com.cristian.portaria.project.services.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApartamentoServiceImpl implements ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;


    @Override
    public ApartamentoResponse criaNovoApartamento(ApartamentoRequest apartamentoRequest) {
        return null;
    }

    @Override
    public ApartamentoResponse atualizaApartamento(ApartamentoRequest apartamentoRequest) {
        return null;
    }

    @Override
    public void buscaApartamentoPeloNumero(String numero) {

    }

    @Override
    public ApartamentoResponse buscaTodosApartamentosPeloAndar(int andar) {
        return null;
    }
}
