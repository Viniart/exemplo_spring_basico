package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.pessoa.PessoaModel;
import br.com.edusync.exemplo.pessoa.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class EmpresaController {


    @Autowired
    private EmpresaService service;

    @GetMapping(value = "/empresas")
    @Operation(summary = "Retorna a lista de empresas", description = "Método que acessa o método listarTodos do service para exibir a lista de empresas")
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso"
    )
    public ResponseEntity listarEmpresas() {
        return new ResponseEntity(service.listarTodos(), HttpStatus.OK);
    }

    @PostMapping(value = "/empresas/novo")
    @Operation(summary = "Cadastra uma nova empresa", description = "Método que acessa o método cadastrarEmpresa do service passando uma empresa a ser cadastrada")
    @ApiResponse(
            responseCode = "201",
            description = "Cadastro bem sucedido!"
    )
    public ResponseEntity cadastrarEmpresa(@RequestBody EmpresaModel empresa) {

        service.cadastrarEmpresa(empresa);
        return new ResponseEntity("Cadastrado com Sucesso!", HttpStatus.CREATED);

    }


    @DeleteMapping(value = "/empresas/deletar/{cnpj}")
    @Operation(summary = "Exclui uma empresa", description = "Método que acessa o método deletarEmpresa do service passando o cnpj para a remover da lista")
    @ApiResponse(
            responseCode = "200",
            description = "Exclusão bem sucedida!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Empresa não encontrada!"
    )
    public ResponseEntity excluirEmpresa(@PathVariable String cnpj) {

        try {
            service.deletarEmpresa(cnpj);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity("CNPJ Inválido!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Excluído com Sucesso", HttpStatus.OK);

    }
}
