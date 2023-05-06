package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.pessoa.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, String> {
}
