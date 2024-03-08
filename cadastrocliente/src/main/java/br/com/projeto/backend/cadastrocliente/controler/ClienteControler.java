package br.com.projeto.backend.cadastrocliente.controler;

import br.com.projeto.backend.cadastrocliente.model.Cliente;
import br.com.projeto.backend.cadastrocliente.repository.ClienteRepository;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.ArrayList;

@Controller
@RequestMapping("/cliente")
public class ClienteControler {

    @Autowired
    private ClienteRepository repositorio;

    @GetMapping("/listar")
    public String listarCliente(Model model){

        model.addAttribute("listaCliente",repositorio.findAll());

        return "listar-cliente";
    }

    @GetMapping("/adicionar")
    public String adicionar(Cliente cliente){
        return "salvar";
    }
    @PostMapping("/salvar")
    public String salvar(@Valid Cliente cliente, BindingResult result){

        if (result.hasErrors()){
            return "salvar";
        }

        repositorio.save(cliente);
        return "redirect:/cliente/listar";
    }
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id")int id){
        Cliente clienteASerExcluir = repositorio.getById(id);

        repositorio.delete(clienteASerExcluir);
        return "redirect:/cliente/listar";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id")int id, Model model){
        Cliente clienteParaEditar = repositorio.getById(id);

        model.addAttribute("cliente",clienteParaEditar);
        return "editar-cliente";

    }
    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable("id")int id, Cliente clienteAtualizado){
        Cliente clienteExistente = repositorio.getById(id);

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setDataNascimento(clienteAtualizado.getDataNascimento());

        repositorio.save(clienteExistente);

        return "redirect:/cliente/listar";
    }
}
