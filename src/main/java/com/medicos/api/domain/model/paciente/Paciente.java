package com.medicos.api.domain.model.paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacientes")
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha = cpf;
    private String telefone;

    // public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
    // if (dados.nome() != null) {
    // this.nome = dados.nome();
    // }

    // if (dados.email() != null) {
    // this.email = dados.email();
    // }

    // if (dados.telefone() != null) {
    // this.telefone = dados.telefone();
    // }
    // }
}