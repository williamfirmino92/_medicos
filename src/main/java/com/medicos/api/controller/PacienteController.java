package com.medicos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.medicos.api.domain.model.paciente.Paciente;
import com.medicos.api.domain.model.paciente.PacienteRepository;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping("/cadastrar")
    public String mostrarFormularioPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "paciente/cadastrar_paciente";
    }

    @PostMapping("/cadastrar")
    public String cadastrarPaciente(Paciente paciente) {
        repository.save(paciente);
        return "redirect:/";
    }

    @GetMapping("/listar")
    public String listarPaciente(Model model) {
        model.addAttribute("pacientes", repository.findAll());
        return "paciente/listar_paciente";
    }

    // @PostMapping
    // @Transactional
    // public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
    // pacienteRepository.save(new Paciente(dados));
    // }

    // @PutMapping
    // @Transactional
    // public void atualizar(@RequestBody DadosAtualizacaoPaciente dados) {
    // var paciente = pacienteRepository.getReferenceById(dados.id());
    // paciente.atualizarInformacoes(dados);
    // }

    // @DeleteMapping("/{id}")
    // @Transactional
    // public void excluir(@PathVariable Integer id) {
    // pacienteRepository.deleteById(id);
    // }

    // Listagem e Busca de pacientes

    // @GetMapping("/listar")
    // public List<DadosListagemPacientes> listarPacientes() {
    // return pacienteRepository.findAll()
    // .stream()
    // .map(DadosListagemPacientes::new)
    // .toList(); // Para converter a lista para stream.
    // }

    // @GetMapping
    // public List<DadosListagemPacientes> buscarPorNome(@RequestParam String nome)
    // {
    // return pacienteRepository.findByNomeContainingIgnoreCase(nome)
    // .stream()
    // .map(DadosListagemPacientes::new)
    // .toList();
    // }

}
