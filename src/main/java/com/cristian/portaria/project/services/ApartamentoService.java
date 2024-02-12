package com.cristian.portaria.project.services;

import com.cristian.portaria.project.dtos.request.ApartamentoRequest;
import com.cristian.portaria.project.dtos.response.ApartamentoResponse;

public interface ApartamentoService {

    ApartamentoResponse criaNovoApartamento(ApartamentoRequest apartamentoRequest);

    ApartamentoResponse atualizaApartamento(ApartamentoRequest apartamentoRequest);

    void buscaApartamentoPeloNumero(String numero);

    ApartamentoResponse buscaTodosApartamentosPeloAndar(int andar);

}
