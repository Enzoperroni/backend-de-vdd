package br.com.projeto.backend.cadastrocliente.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class Cliente {
    private int id;
    @NotBlank(message="Campo nome é obrigatório")
    private String nome;
    @NotBlank(message="Cmapo email é obrigatório")
    @Email(message="Formato do email está incorreto")
    private String email;
    @NotBlank(message="Campo cpf é obirgatório")
    private String cpf;
    @NotBlank(message="Campo data de nascimento é obrigatório")
    private String dataNascimento;
}
