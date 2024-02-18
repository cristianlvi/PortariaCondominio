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
import java.util.Set;

@Entity
@Table(name = "MORADORES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_morador")
    private Long id;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "morador", nullable = false)
    private String nome;

    @Email
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartamento_id")
    private List<Apartamento> apartamentos;

    @OneToOne(mappedBy = "morador", cascade = CascadeType.ALL)
    private User usuario;


    @Override
    public String toString() {
        return "Morador{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", numero=" + apartamentos + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}