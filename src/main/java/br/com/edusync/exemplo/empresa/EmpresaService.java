package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaModel> listarTodos() {
        return empresaRepository.findAll();
    }

    public void cadastrarEmpresa(EmpresaModel pessoa) {
        empresaRepository.save(pessoa);
    }

    public EmpresaModel buscarEmpresaPorCnpj(String cnpj) {
        Optional<EmpresaModel> empresa = empresaRepository.findById(cnpj);

        if(empresa.isEmpty()) {
            return null;
        }
        return empresa.get();
    }

    public void deletarEmpresa(String cnpj) {
        if(empresaRepository.existsById(cnpj))
            empresaRepository.deleteById(cnpj);
    }

    public void editarEmpresa(String cnpj, EmpresaModel empresa) {
        if(empresaRepository.existsById(cnpj))
            empresaRepository.save(empresa);
    }
}
