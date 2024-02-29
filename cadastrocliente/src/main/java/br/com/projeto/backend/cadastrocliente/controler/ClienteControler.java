package br.com.projeto.backend.cadastrocliente.controler;

import br.com.projeto.backend.cadastrocliente.model.Cliente;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.util.ArrayList;

@Controller
@RequestMapping("/cliente")
public class ClienteControler {
    @GetMapping("/listar")
    public String listarCliente(Model model){
        ArrayList<Cliente>lista = new ArrayList<Cliente>();
        Cliente cliente = new Cliente();
        cliente.setNome("Enzo Perroni");
        cliente.setEmail("qqcoisa@gmail.com");
        cliente.setCpf("111.111.111-11");
        cliente.setDataNascimento("01/01/2001");

        lista.add(cliente);

        model.addAttribute("listaCliente",lista);

        return "listar-cliente";
    }
}
