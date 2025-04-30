package com.medicos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.medicos.api.domain.model.medico.Especialidade;
import com.medicos.api.domain.model.medico.Medico;
import com.medicos.api.domain.model.medico.MedicoRepository;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping("/cadastrar")
    public String mostrarFormularioMedico(Model model) {
        model.addAttribute("medico", new Medico());
        model.addAttribute("especialidades", Especialidade.values());
        return "medico/cadastrar_medico";
    }

    @PostMapping("/cadastrar")
    public String cadastrarMedico(Medico medico) {
        repository.save(medico);
        return "redirect:/";
    }

    @GetMapping("/listar")
    public String listarMedico(Model model) {
        model.addAttribute("medicos", repository.findAll());
        return "medico/listar_medico";
    }

    @GetMapping("/medicos/por-especialidade")
    @ResponseBody
    public List<Medico> listarPorEspecialidade(@RequestParam Especialidade especialidade) {
        return repository.findByEspecialidade(especialidade);
    }

    // Aqui fica o método de atualização - UPDATE
    // nome, email, endereco
    // @PutMapping
    // @Transactional
    // public void atualizar(@RequestBody DadosAtualizacaoMedico dados) {
    // var medico = medicoRepository.getReferenceById(dados.id());
    // medico.atualizarInformacoes(dados);
    // }

    // Aqui fica o método de exclusão - DELETE

    // Exclusão - Estou excluindo mesmo.
    // @DeleteMapping("/{id}")
    // @Transactional
    // public void excluir(@PathVariable Integer id){
    // repository.deleteById(id);
    // }

    // Exclusão Lógica - Uma regra de negócio que permite que um registro seja
    // excluido sem apagar do banco de dados
    // @DeleteMapping("/{id}")
    // @Transactional
    // public void excluir(@PathVariable Integer id) {
    // var medico = medicoRepository.getReferenceById(id);
    // medico.exclusaoLogica();
    // }

    // Aqui fica o método de consulta - READ

}
