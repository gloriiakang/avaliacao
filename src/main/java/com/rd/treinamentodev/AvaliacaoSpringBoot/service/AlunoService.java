package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Fabio, nesse método gravar, aparentemente consegui validar o campo CPF,
    // E ele não grava no banco caso já exista um cpf igual,
    // porém ele ficou meio esquisito e não deu tempo pra eu deixar ele melhor...
    @Transactional
    public ResponseEntity gravar(AlunoDTO alunoDTO){
        AlunoEntity entity = new AlunoEntity();
        entity.setNomeAluno(alunoDTO.getNome());
        entity.setCpf(alunoDTO.getCpf());

        //TODO validar se o CPF existe no banco antes de existir, caso exista retornar mensagem de erro
    if (alunoDTO.getCpf().equals(entity.getCpf())) {
        System.out.println("CPF já cadastrado!");
    } else {
        alunoRepository.save(entity);
    }
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro realizado!");
    }
}
