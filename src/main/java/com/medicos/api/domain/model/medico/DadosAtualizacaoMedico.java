package com.medicos.api.domain.model.medico;

import com.medicos.api.domain.model.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(Integer id, String nome, String email, DadosEndereco endereco) {

}
