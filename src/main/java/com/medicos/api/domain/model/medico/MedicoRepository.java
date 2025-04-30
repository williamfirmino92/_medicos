package com.medicos.api.domain.model.medico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    List<Medico> findByEspecialidade(Especialidade especialidade);

}
