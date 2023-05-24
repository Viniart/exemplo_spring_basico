package br.com.edusync.exemplo.pessoa;

import br.com.edusync.exemplo.empresa.EmpresaModel;
import br.com.edusync.exemplo.empresa.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPessoaFacadeImpl implements CadastrarPessoaFacade{

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private PessoaService pessoaService;

    @Override
    public void cadastrarPessoa(PessoaModel pessoa, String cnpj) {
        EmpresaModel empresa = empresaService.buscarEmpresaPorCnpj(cnpj);

        pessoa.setEmpresa(empresa);

        pessoaService.cadastrarPessoa(pessoa);
    }

}
