package br.com.edusync.exemplo.pessoa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

// @Data é a anotação do Lombok que gera os Getters/Setters e Construtor automaticamente
@Data
@Entity(name = "tb_pessoa")
// Modelo de Pessoa
public class PessoaModel {

    @Id
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String rotaImagem;
    @ManyToOne
    private EmpresaModel model;

}


