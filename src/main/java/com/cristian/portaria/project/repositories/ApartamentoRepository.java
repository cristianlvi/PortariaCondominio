package com.cristian.portaria.project.repositories;

import com.cristian.portaria.project.domain.apartamento.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    List<Apartamento> findByNumeroApartamento(String numero);

    List<Apartamento> findByAndar(int andar);

}
