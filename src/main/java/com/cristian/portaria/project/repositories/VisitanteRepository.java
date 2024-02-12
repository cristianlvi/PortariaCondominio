package com.cristian.portaria.project.repositories;

import com.cristian.portaria.project.domain.visitante.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, String> {
}
