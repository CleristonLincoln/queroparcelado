package br.com.queroparcelado.api.controller;

import br.com.queroparcelado.domain.model.Cliente;
import br.com.queroparcelado.domain.model.dto.ValidarClienteDTO;
import br.com.queroparcelado.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("permitAll()")
@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public List<Cliente> listaClientes() {
        return clienteService.buscarClientes();
    }

    @GetMapping("{idCliente}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long idCliente){
        return clienteService.buscarCliente(idCliente);
    }

    @GetMapping("nome/{nomeCliente}")
    public ResponseEntity<List<Cliente>> buscarClientePorNome(@PathVariable String nomeCliente){
        return clienteService.buscarClientePorNome(nomeCliente);
    }

    @GetMapping("cpf/{cpfCliente}")
    public ResponseEntity<Cliente> buscarClientePorCpf(@PathVariable String cpfCliente){
        return clienteService.buscarClientePorCpf(cpfCliente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@Valid @RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    @PutMapping("{idCliente}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long idCliente, @RequestBody Cliente cliente){
        return clienteService.updateCliente(idCliente, cliente);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }


    @PostMapping("/validar-senha")
    @ResponseStatus(HttpStatus.OK)
    public Boolean validarSenha(@RequestBody ValidarClienteDTO validarClienteDTO){
        return clienteService.validarSenhaCliente(validarClienteDTO.getCpfCliente(), validarClienteDTO.getSenha());
    }

    @GetMapping("/ativo/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean validarClienteAtivo(@PathVariable Long idCliente){
        return clienteService.validarSeClienteAtivo(idCliente);

    }

    @GetMapping("/regerar-senha/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean gererarSenha(@PathVariable String cpf){
        return clienteService.gerarNovaSenha(cpf);

    }
}
