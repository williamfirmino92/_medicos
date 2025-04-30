package com.medicos.api.domain.model.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    List<Consulta> findByMedicoNomeContainingIgnoreCase(String nome);

    List<Consulta> findByPacienteNomeContainingIgnoreCase(String nome);

    List<Consulta> findByMedicoEspecialidade(Enum especialidade); // Especialidade é um Enum
}
