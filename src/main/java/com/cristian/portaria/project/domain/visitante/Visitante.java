package com.cristian.portaria.project.domain.visitante;

import com.cristian.portaria.project.domain.morador.Morador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VISITANTES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Visitante {

    @Id
    private String cpf;

    @Column(name = "nome_visitante")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_morador", nullable = false)
    private Morador morador;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitante visitante = (Visitante) o;
        return Objects.equals(cpf, visitante.cpf) && Objects.equals(nome, visitante.nome) && Objects.equals(morador, visitante.morador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, morador);
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", morador=" + morador +
                '}';
    }
}
