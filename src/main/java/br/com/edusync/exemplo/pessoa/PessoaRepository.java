package br.com.edusync.exemplo.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<PessoaModel, String> {
    public List<PessoaModel> findByNome(String nome);
}
