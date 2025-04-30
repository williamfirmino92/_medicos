package com.medicos.api.domain.model.medico;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicos")
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String crm;
    private Boolean ativo = true;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    // Método responsável por realizar a verificação de qual campo está sendo
    // atualizado.
    // public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
    // if (dados.nome() != null) {
    // this.nome = dados.nome();
    // }
    // if (dados.email() != null) {
    // this.email = dados.email();
    // }
    // if (dados.endereco() != null) {
    // this.endereco.atualizarInformacoes(dados.endereco());
    // }
    // }

    // public void exclusaoLogica() {
    // this.ativo = false;
    // }

}
