package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.pessoa.PessoaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.security.spec.NamedParameterSpec;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "empresa")
public class EmpresaModel {
    @Id
    private String cnpj;
    private String nome;

    // Bidirecional
    // private List<PessoaModel> pessoas;
}
