package com.cristian.portaria.project.repositories;

import com.cristian.portaria.project.domain.morador.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {
}
