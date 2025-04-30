package com.medicos.api.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// import com.medicos.api.model.medico.MedicoRepository;

@Controller
@RequestMapping("/")
public class SiteController {

    // @Autowired
    // private MedicoRepository repository;

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "login/cadastro";
    }

}
