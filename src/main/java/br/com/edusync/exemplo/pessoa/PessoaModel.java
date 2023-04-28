package br.com.edusync.exemplo.pessoa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

// @Data é a anotação do Lombok que gera os Getters/Setters e Construtor automaticamente
@Getter
@Setter
@Entity(name = "pessoa")
// Modelo de Pessoa
public class PessoaModel {

    @Id
    private String cpf;
    private String nome;
    private Date dataNascimento;
    private String rotaImagem;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    // IMPORTANTE!! Evita o Loop entre Pessoas e Empresa, e como a Empresa é Lazy Loaded
    // Ele também soluciona um erro causado pelas propriedades lazyinitializer e handler
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "pessoas"})
    // @JsonIgnore - Outra opção, ignora a propriedade empresa o que evita o Loop
    // @JsonBackReference - Usando em conjunto com o @JsonManagedReference na Empresa também evita o loop
    private EmpresaModel empresa;

}


