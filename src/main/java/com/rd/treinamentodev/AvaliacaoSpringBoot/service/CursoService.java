package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public String cadastrarCurso(CursoDTO cursoDTO) {
        CursoEntity cursoEntity = new CursoEntity();

        cursoEntity.setDsCurso(cursoDTO.getDsCurso());
        cursoEntity.setNrCargaHoraria(cursoDTO.getCargaHoraria());

        cursoRepository.save(cursoEntity);

        return "Curso cadastrado com sucesso!";
    }

    public List<CursoEntity> consultarPorNome(String dsCurso) {
        return cursoRepository.findByDsCurso(dsCurso);
    }
}
