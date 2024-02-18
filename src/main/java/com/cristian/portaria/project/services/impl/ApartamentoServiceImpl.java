package com.cristian.portaria.project.services.impl;

import com.cristian.portaria.project.config.ModelMapperConfig;
import com.cristian.portaria.project.domain.apartamento.Apartamento;
import com.cristian.portaria.project.dtos.request.ApartamentoRequest;
import com.cristian.portaria.project.dtos.response.ApartamentoResponse;
import com.cristian.portaria.project.exception.custons.ApartamentoException;
import com.cristian.portaria.project.exception.custons.VerificaAndarException;
import com.cristian.portaria.project.repositories.ApartamentoRepository;
import com.cristian.portaria.project.services.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class ApartamentoServiceImpl implements ApartamentoService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    private ModelMapperConfig modelMapper;


    @Override
    public ApartamentoResponse atualizaApartamento(ApartamentoRequest apartamentoRequest) {
        if (Objects.isNull(apartamentoRequest.numero())) {
            throw new ApartamentoException("numero invalido");
        }
        Apartamento apartamento = modelMapper.modelMapper().map(apartamentoRequest, Apartamento.class);

        apartamentoRepository.save(apartamento);

        return modelMapper.modelMapper().map(apartamento, ApartamentoResponse.class);
    }

    @Override
    public ApartamentoResponse buscaApartamentoPeloNumero(String numero) {
        Apartamento apartamento = apartamentoRepository.findByNumero(numero)
                .orElseThrow(() -> new ApartamentoException("erro na busca do apartamento"));

        return modelMapper.modelMapper().map(apartamento, ApartamentoResponse.class);
    }

    @Override
    public ApartamentoResponse buscaTodosApartamentosPeloAndar(int andar) {
        List<Apartamento> apartamento = apartamentoRepository.findByAndar(verificaAndar(andar)).stream().toList();

        return modelMapper.modelMapper().map(apartamento, ApartamentoResponse.class);
    }

    private static int verificaAndar(int andar) {
        if (andar < 1 || andar > 10) throw new VerificaAndarException("Andar invalido");

        return andar;
    }


}
