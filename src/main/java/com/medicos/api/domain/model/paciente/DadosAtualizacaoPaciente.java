package com.medicos.api.domain.model.paciente;

import com.medicos.api.domain.model.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(Integer id, String email, String nome, String telefone, DadosEndereco endereco) {

}
