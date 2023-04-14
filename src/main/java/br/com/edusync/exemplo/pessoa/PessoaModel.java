package br.com.edusync.exemplo.pessoa;

import lombok.Data;

import java.util.Date;

// @Data é a anotação do Lombok que gera os Getters/Setters e Construtor automaticamente
@Data
// Modelo de Pessoa
public class PessoaModel {

    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String rotaImagem;

}


