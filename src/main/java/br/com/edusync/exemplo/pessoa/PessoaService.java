package br.com.edusync.exemplo.pessoa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import br.com.edusync.exemplo.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> listarTodos() {
        return pessoaRepository.findAll();
    }

    public void cadastrarPessoa(PessoaModel pessoa) {
        pessoaRepository.save(pessoa);
    }

    public PessoaModel buscarPessoaPorCpf(String cpf) {
        Optional<PessoaModel> pessoa = pessoaRepository.findById(cpf);

        if(pessoa.isEmpty()) {
            return null;
        }
        return pessoa.get();
    }

    public void deletarPessoa(String cpf) {
        if(pessoaRepository.existsById(cpf))
            pessoaRepository.deleteById(cpf);
    }

    public void editarPessoa(String cpf, PessoaModel pessoaNova) {
        if(pessoaRepository.existsById(cpf))
            pessoaRepository.save(pessoaNova);
    }

}
