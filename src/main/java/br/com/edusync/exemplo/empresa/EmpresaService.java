package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import br.com.edusync.exemplo.pessoa.PessoaModel;
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

    public void cadastrarEmpresa(EmpresaModel empresa) {
        empresaRepository.save(empresa);
    }

    public EmpresaModel buscarEmpresaPorCnpj(String cnpj) {
        Optional<EmpresaModel> empresa = empresaRepository.findById(cnpj);

        if(empresa.isEmpty()){
            return null;
        }

        return empresa.get();
    }

    public void deletarEmpresa(String cpf) {
        empresaRepository.deleteById(cpf);
    }

    public void editarEmpresa(String cpf, EmpresaModel empresaNova) {
        empresaRepository.save(empresaNova);
    }
}
