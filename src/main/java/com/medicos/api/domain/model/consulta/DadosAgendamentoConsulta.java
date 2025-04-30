package com.medicos.api.domain.model.consulta;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
        Integer medicoId,
        Integer pacienteId,
        String observacao,
        Status status,
        LocalDateTime data

)

{

}
