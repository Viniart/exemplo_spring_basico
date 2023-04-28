package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.pessoa.PessoaModel;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "empresa")
public class EmpresaModel {

    @Id
    private String cnpj;
    private String nome;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "empresa"
    )
    // @JsonManagedReference
    @JsonIgnoreProperties("empresa")
    private List<PessoaModel> pessoas = new ArrayList<PessoaModel>();


}
