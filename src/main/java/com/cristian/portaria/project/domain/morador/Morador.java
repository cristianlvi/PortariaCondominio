package com.cristian.portaria.project.domain.morador;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Morador {

    private String nome;
    private String email;
    private String sexo;
    private long numeroApartamento;
    private int andar;

    @OneToOne(mappedBy = "morador", cascade = CascadeType.ALL)
    private List<User> usuario;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Morador morador = (Morador) o;
        return numeroApartamento == morador.numeroApartamento && andar == morador.andar && Objects.equals(usuario, morador.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroApartamento, andar, usuario);
    }
}
