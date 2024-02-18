package com.cristian.portaria.project.controller;

import com.cristian.portaria.project.dtos.request.ApartamentoRequest;
import com.cristian.portaria.project.dtos.response.ApartamentoResponse;
import com.cristian.portaria.project.services.ApartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @Operation(summary = "Atualiza o apartamento", method = "PUT")

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/atualiza")
    public ResponseEntity atualizaApartamento(@RequestBody ApartamentoRequest apartamentoRequest) {
        ApartamentoResponse response = apartamentoService.atualizaApartamento(apartamentoRequest);

        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Busca um apartamento pelo seu número", method = "GET")

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{numero}")
    public ResponseEntity getApartamentoNumero(@PathVariable String numero) {
        ApartamentoResponse response = apartamentoService.buscaApartamentoPeloNumero(numero);

        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Busca todos os apartamentos pelo andar", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "buscou todos os apartamentos"),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos")
    })
    @GetMapping("/andar/{andar}")
    public ResponseEntity todosApartamentosAndar(@PathVariable int andar) {
        ApartamentoResponse listResponse = apartamentoService.buscaTodosApartamentosPeloAndar(andar);

        return ResponseEntity.ok().body(listResponse);


    }


}
