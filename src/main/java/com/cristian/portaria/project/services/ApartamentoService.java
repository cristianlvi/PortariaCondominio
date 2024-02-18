package com.cristian.portaria.project.services;

import com.cristian.portaria.project.domain.apartamento.Apartamento;
import com.cristian.portaria.project.dtos.request.ApartamentoRequest;
import com.cristian.portaria.project.dtos.response.ApartamentoResponse;

import java.util.Set;

public interface ApartamentoService {


    ApartamentoResponse atualizaApartamento(ApartamentoRequest apartamentoRequest);

    ApartamentoResponse buscaApartamentoPeloNumero(String numero);

    ApartamentoResponse buscaTodosApartamentosPeloAndar(int andar);

}
