package com.medicos.api.domain.model.consulta;

import java.time.LocalDateTime;

public record DadosConsultaListagem(
        Integer id,
        String nomePaciente,
        String nomeMedico,
        String especialidade, // <- adicionado
        LocalDateTime data) {
    public DadosConsultaListagem(Consulta consulta) {
        this(
                consulta.getId(),
                consulta.getPaciente().getNome(),
                consulta.getMedico().getNome(),
                consulta.getMedico().getEspecialidade().toString(), // <- extraído do médico
                consulta.getData());
    }
}
