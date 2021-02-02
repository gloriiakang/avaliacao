package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.InstrutorDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.InstrutorEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public List<TurmaDTO> listar(){
        List<TurmaEntity> listEntity = turmaRepository.findAll();
        List<TurmaDTO> listDTO = new ArrayList<>();

        for (TurmaEntity entity : listEntity) {
            TurmaDTO turma = new TurmaDTO();

            List<AlunoEntity> alunosEntity = entity.getAlunos();
            List<AlunoDTO> alunosDTO = new ArrayList<>();

            for (AlunoEntity alunoEntity : alunosEntity) {
                AlunoDTO aluno = new AlunoDTO();
                aluno.setNome(alunoEntity.getNomeAluno());
                aluno.setCpf(alunoEntity.getCpf());

                alunosDTO.add(aluno);
            }

            turma.setAlunos(alunosDTO);
            listDTO.add(turma);

            List<InstrutorEntity> instrutoresEntity = entity.getInstrutores();
            List<InstrutorDTO> instrutoresDTO = new ArrayList<>();
            for (InstrutorEntity instrutorEntity : instrutoresEntity) {
                InstrutorDTO instrutor = new InstrutorDTO();
                instrutor.setNome(instrutorEntity.getNomeInstrutor());
                instrutor.setValorHora(instrutorEntity.getValorHora());

                instrutoresDTO.add(instrutor);
            }

            turma.setInstrutores(instrutoresDTO);
            listDTO.add(turma);
        }

        return listDTO;
    }
}
