package br.com.edusync.exemplo.pessoa;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class PessoaController {

    // Lembrando que Autowired só funciona com classes BEANS Java! Exemplo: Classes
    // com anotação @Service, @Beans, etc
    @Autowired
    private PessoaService service;

    // Get - Trazer, Post - Cadastrar, Put - Editar, Patch - Editar, Delete - Deletar
    @GetMapping(value = "/pessoas")
    @Operation(summary = "Retorna a lista de pessoas", description = "Método que acessa o método listarTodos do service para exibir a lista de pessoas")
    @ApiResponse(
            responseCode = "200",
            description = "Sucesso"
    )
    public ResponseEntity listarPessoas() {
        return new ResponseEntity(service.listarTodos(), HttpStatus.OK);
    }

    @PostMapping(value = "/pessoas/novo")
    @Operation(summary = "Cadastra uma nova pessoa", description = "Método que acessa o método cadastrarPessoa do service passando uma pessoa a ser cadastrada")
    @ApiResponse(
            responseCode = "201",
            description = "Cadastro bem sucedido!"
    )
    public ResponseEntity cadastrarPessoa(@RequestBody PessoaModel pessoa) {

        service.cadastrarPessoa(pessoa);
        return new ResponseEntity("Cadastrado com Sucesso!", HttpStatus.CREATED);

    }


    @DeleteMapping(value = "/pessoas/deletar/{cpf}")
    @Operation(summary = "Exclui uma pessoa", description = "Método que acessa o método deletarPessoa do service passando o cpf para a remover da lista")
    @ApiResponse(
            responseCode = "200",
            description = "Exclusão bem sucedida!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Cpf não encontrado!"
    )
    //                                  Variável de rota
    public ResponseEntity excluirPessoa(@PathVariable String cpf) {

//      Exemplo de tratamento de exceção (orElseThrow retorna NoSuchElementException, que eu pego e
//      transformo em uma mensagem de CPF Inválido
        try {
            service.deletarPessoa(cpf);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity("CPF Inválido!", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity("Excluído com Sucesso", HttpStatus.OK);

    }


}
