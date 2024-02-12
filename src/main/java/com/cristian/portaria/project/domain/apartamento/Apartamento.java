package com.cristian.portaria.project.domain.apartamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity
@Table(name = "APARTAMENTOS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "n_apartamento", nullable = false)
    private String numeroApartamento;

    @Column(name = "andar", nullable = false)
    private int andar;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento that = (Apartamento) o;
        return andar == that.andar
                && Objects.equals(id, that.id)
                && Objects.equals(numeroApartamento, that.numeroApartamento)
                && situacao == that.situacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroApartamento, andar, situacao);
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "id=" + id +
                ", numeroApartamento='" + numeroApartamento + '\'' +
                ", andar=" + andar +
                ", situacao=" + situacao +
                '}';
    }
}
