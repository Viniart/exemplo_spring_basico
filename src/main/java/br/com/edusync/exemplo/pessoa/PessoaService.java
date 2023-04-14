package br.com.edusync.exemplo.pessoa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    List<PessoaModel> listaPessoas = new ArrayList<PessoaModel>();

    public List<PessoaModel> listarTodos() {
        return listaPessoas;
    }

    public void cadastrarPessoa(PessoaModel pessoa) {
        listaPessoas.add(pessoa);
    }

    public PessoaModel buscarPessoaPorCpf(String cpf) {
        return listaPessoas.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().orElseThrow();
    }

    public void deletarPessoa(String cpf) {
        PessoaModel pessoa = buscarPessoaPorCpf(cpf);
        listaPessoas.remove(pessoa);
    }

    public void editarPessoa(String cpf, PessoaModel pessoaNova) {
        PessoaModel pessoaAntiga = buscarPessoaPorCpf(cpf);

        listaPessoas.remove(pessoaAntiga);
        listaPessoas.add(pessoaNova);
    }

}
