package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    List<EmpresaModel> listaEmpresas = new ArrayList<EmpresaModel>();

    public List<EmpresaModel> listarTodos() {
        return listaEmpresas;
    }

    public void cadastrarEmpresa(EmpresaModel pessoa) {
        listaEmpresas.add(pessoa);
    }

    public EmpresaModel buscarEmpresaPorCnpj(String cnpj) {
        return listaEmpresas.stream().filter(p -> p.getCnpj().equals(cnpj)).findFirst().orElseThrow();
    }

    public void deletarEmpresa(String cpf) {
        EmpresaModel empresa = buscarEmpresaPorCnpj(cpf);
        listaEmpresas.remove(empresa);
    }

    public void editarEmpresa(String cnpj, EmpresaModel empresaNova) {
        EmpresaModel empresaAntiga = buscarEmpresaPorCnpj(cnpj);

        listaEmpresas.remove(empresaAntiga);
        listaEmpresas.add(empresaNova);
    }
}
