package com.medicos.api.domain.model.paciente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByNomeContainingIgnoreCase(String nome);

}
