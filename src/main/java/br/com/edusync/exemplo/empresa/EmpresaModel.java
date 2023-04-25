package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.pessoa.PessoaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class EmpresaModel {

    @Id
    private String cnpj;
    private String nome;
    @OneToMany
    private List<PessoaModel> pessoas;


}
