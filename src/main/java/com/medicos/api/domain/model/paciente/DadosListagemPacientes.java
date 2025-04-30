package com.medicos.api.domain.model.paciente;

public record DadosListagemPacientes(Integer id, String nome, String email, String telefone) {
    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }
}
