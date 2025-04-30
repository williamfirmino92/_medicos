package com.medicos.api.domain.model.consulta;

import java.time.LocalDateTime;

import com.medicos.api.domain.model.medico.Medico;
import com.medicos.api.domain.model.paciente.Paciente;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private String observacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime data;

    // public void atualizarInformacoes(DadosAtualizacaoConsulta dados) {
    // if (dados.observacao() != null) {
    // this.observacao = dados.observacao();
    // }
    // if (dados.status() != null) {
    // this.status = dados.status();
    // }
    // if (dados.data() != null) {
    // this.data = dados.data();
    // }
    // }
}
