package br.com.edusync.exemplo.pessoa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

// @Data é a anotação do Lombok que gera os Getters/Setters e Construtor automaticamente
@Data
@Entity(name = "pessoa")
// Modelo de Pessoa
public class PessoaModel {
// Models -> Repositories -> Services -> Controllers
    @Id
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String rotaImagem;

//  2 Formas de associar entidades - Unidirecional, Bidirecional
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaModel empresa;

}


