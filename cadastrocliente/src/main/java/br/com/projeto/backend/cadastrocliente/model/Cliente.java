package br.com.projeto.backend.cadastrocliente.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    @NotBlank(message="Campo nome é obrigatório")
    private String nome;

    @Column
    @NotBlank(message="Cmapo email é obrigatório")
    @Email(message="Formato do email está incorreto")
    private String email;

    @Column
    @NotBlank(message="Campo cpf é obirgatório")
    private String cpf;

    @Column
    @NotBlank(message="Campo data de nascimento é obrigatório")
    private String dataNascimento;
}
