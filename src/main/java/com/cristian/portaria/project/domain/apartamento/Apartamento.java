package com.cristian.portaria.project.domain.apartamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


@Entity(name = "APARTAMENTOS")
@Table(name = "APARTAMENTOS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "andar", nullable = false)
    private int andar;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento that = (Apartamento) o;
        return andar == that.andar && Objects.equals(id, that.id) && Objects.equals(numero, that.numero) && situacao == that.situacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, andar, situacao);
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", andar=" + andar +
                ", situacao=" + situacao +
                '}';
    }
}
