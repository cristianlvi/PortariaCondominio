package com.cristian.portaria.project.domain.morador;


import com.cristian.portaria.project.domain.apartamento.Apartamento;
import com.cristian.portaria.project.domain.visitante.Visitante;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MORADORES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", unique = true,nullable = false)
    private String cpf;

    @Column(name = "morador", nullable = false)
    private String nome;

    @Email
    private String email;

    @Column(name = "sexo", nullable = false)
    private char sexo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_apartamento")
    private List<Apartamento> apartamento;

    @OneToOne(mappedBy = "morador", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private User usuario;

    @OneToMany(mappedBy = "morador", cascade = CascadeType.ALL)
    private List<Visitante> visitantes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morador morador = (Morador) o;
        return Objects.equals(id, morador.id) && Objects.equals(nome, morador.nome) && Objects.equals(apartamento, morador.apartamento) && Objects.equals(usuario, morador.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, apartamento, usuario);
    }

    @Override
    public String toString() {
        return "Morador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", sexo=" + sexo +
                ", apartamento=" + apartamento +
                ", usuario=" + usuario +
                '}';
    }
}
