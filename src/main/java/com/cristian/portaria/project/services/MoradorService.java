package com.cristian.portaria.project.services;

import com.cristian.portaria.project.dtos.request.MoradorRequest;
import com.cristian.portaria.project.dtos.response.MoradorResponse;

public interface MoradorService {

    MoradorResponse addMorador(MoradorRequest moradorRequest);

    MoradorResponse atualizaMorador(MoradorRequest moradorRequest);

    MoradorResponse apagaMorador(String cpf);

    MoradorResponse buscaMoradorPeloApartamento(int numeroApartamento);

    void verificaMoradorId(int id);



}
