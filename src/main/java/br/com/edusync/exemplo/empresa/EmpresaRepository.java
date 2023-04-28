package br.com.edusync.exemplo.empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, String> {
    public List<EmpresaModel> findByNome(String nome);
}
