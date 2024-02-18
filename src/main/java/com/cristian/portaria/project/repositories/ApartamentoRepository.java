package com.cristian.portaria.project.repositories;

import com.cristian.portaria.project.domain.apartamento.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

    Optional<Apartamento> findByNumero(String numero);

    List<Apartamento> findByAndar(int andar);

}
