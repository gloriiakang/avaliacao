package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/curso")
    public ResponseEntity cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.cadastrarCurso(cursoDTO));
    }

    @GetMapping("/curso/{dsCurso}")
    public ResponseEntity getCurso(@PathVariable("dsCurso") String dsCurso) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.consultarPorNome(dsCurso));
    }
}
