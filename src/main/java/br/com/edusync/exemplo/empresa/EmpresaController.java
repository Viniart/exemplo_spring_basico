package br.com.edusync.exemplo.empresa;

import br.com.edusync.exemplo.empresa.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class EmpresaController {

    // Lembrando que Autowired só funciona com classes BEANS Java! Exemplo: Classes
    // com anotação @Service, @Beans, etc
    @Autowired
    private EmpresaService service;

    // Get - Trazer, Post - Cadastrar, Put - Editar, Patch - Editar, Delete - Deletar
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
    @Operation(summary = "Cadastra uma nova empresa", description = "Método que acessa o método cadastrarempresa do service passando uma empresa a ser cadastrada")
    @ApiResponse(
            responseCode = "201",
            description = "Cadastro bem sucedido!"
    )
    public ResponseEntity cadastrarEmpresa(@RequestBody EmpresaModel empresa) {

        service.cadastrarEmpresa(empresa);
        return new ResponseEntity("Cadastrado com Sucesso!", HttpStatus.CREATED);

    }


    @DeleteMapping(value = "/empresas/deletar/{cnpj}")
    @Operation(summary = "Exclui uma empresa", description = "Método que acessa o método deletarempresa do service passando o cnpj para a remover da lista")
    @ApiResponse(
            responseCode = "200",
            description = "Exclusão bem sucedida!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "cnpj não encontrado!"
    )
    //                                  Variável de rota
    public ResponseEntity excluirEmpresa(@PathVariable String cnpj) {

//      Exemplo de tratamento de exceção (orElseThrow retorna NoSuchElementException, que eu pego e
//      transformo em uma mensagem de cnpj Inválido
        try {
            service.deletarEmpresa(cnpj);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity("cnpj Inválido!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Excluído com Sucesso", HttpStatus.OK);

    }
}
