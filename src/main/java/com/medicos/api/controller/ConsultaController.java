package com.medicos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.medicos.api.domain.model.consulta.Consulta;
import com.medicos.api.domain.model.consulta.ConsultaRepository;
import com.medicos.api.domain.model.medico.Especialidade;
import com.medicos.api.domain.model.medico.Medico;
import com.medicos.api.domain.model.medico.MedicoRepository;
import com.medicos.api.domain.model.paciente.PacienteRepository;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // @GetMapping("/cadastrar")
    // public String mostrarFormularioConsulta(Model model) {
    // model.addAttribute("consulta", new Consulta());
    // model.addAttribute("medicos", medicoRepository.findAll());
    // model.addAttribute("pacientes", pacienteRepository.findAll());
    // // model.addAttribute("especialidades", Especialidade.values());

    // return "consulta/cadastrar_consulta";
    // }

    @GetMapping("/cadastrar")
    public String mostrarFormulario(@RequestParam(required = false) Especialidade especialidade, Model model) {

        model.addAttribute("consulta", new Consulta());
        model.addAttribute("especialidades", Especialidade.values());

        // Se especialidade for informada, filtra. Se não, manda lista vazia
        if (especialidade != null) {
            model.addAttribute("medicos", medicoRepository.findByEspecialidade(especialidade));
        } else {
            model.addAttribute("medicos", List.of()); // lista vazia inicialmente
        }

        model.addAttribute("pacientes", pacienteRepository.findAll());

        return "consulta/cadastrar_consulta";
    }

    @PostMapping("/cadastrar")
    public String cadastrarConsulta(Consulta consulta) {
        consultaRepository.save(consulta);
        return "redirect:/";
    }

    @GetMapping("listar")
    public String listarConsulta(Model model) {
        model.addAttribute("consultas", consultaRepository.findAll());
        return "consulta/listar_consulta";
    }

    // @PutMapping
    // @Transactional
    // private void atualizar(@RequestBody DadosAtualizacaoConsulta dados) {
    // var consulta = consultaRepository.getReferenceById(dados.id());
    // consulta.atualizarInformacoes(dados);
    // }

    // @DeleteMapping("/{id}")
    // @Transactional
    // public void excluir(@PathVariable Integer id) {
    // consultaRepository.deleteById(id);
    // }

    // @PostMapping
    // @Transactional
    // public ResponseEntity<?> agendar(@RequestBody DadosAgendamentoConsulta dados)
    // {
    // var medico = medicoRepository.findById(dados.medicoId())
    // .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
    // var paciente = pacienteRepository.findById(dados.pacienteId())
    // .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

    // var consulta = new Consulta();
    // consulta.setMedico(medico);
    // consulta.setPaciente(paciente);
    // consulta.setObservacao(dados.observacao());
    // consulta.setStatus(dados.status());
    // consulta.setData(dados.data());

    // consultaRepository.save(consulta);

    // return ResponseEntity.status(201).build();
    // }

    // @GetMapping
    // public ResponseEntity<?> listarTodas() {
    // var consultas = consultaRepository.findAll();
    // return ResponseEntity.ok(consultas);
    // }

    // @GetMapping("/medico")
    // public ResponseEntity<?> listarPorMedico(@RequestParam String nome) {
    // var consultas = consultaRepository.findByMedicoNomeContainingIgnoreCase(nome)
    // .stream()
    // .map(DadosConsultaListagem::new)
    // .toList();
    // return ResponseEntity.ok(consultas);
    // }

    // @GetMapping("/paciente")
    // public ResponseEntity<?> listarPorPaciente(@RequestParam String nome) {
    // var consultas =
    // consultaRepository.findByPacienteNomeContainingIgnoreCase(nome)
    // .stream()
    // .map(DadosConsultaListagem::new)
    // .toList();
    // return ResponseEntity.ok(consultas);
    // }

    // @GetMapping("/especialidade")
    // public ResponseEntity<?> listarPorEspecialidade(@RequestParam Especialidade
    // tipo) {
    // var consultas = consultaRepository.findByMedicoEspecialidade(tipo)
    // .stream()
    // .map(DadosConsultaListagem::new)
    // .toList();
    // return ResponseEntity.ok(consultas);
    // }

}
