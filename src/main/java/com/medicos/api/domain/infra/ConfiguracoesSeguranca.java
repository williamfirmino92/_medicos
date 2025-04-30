package com.medicos.api.domain.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuração de segurança.
 * Define dois usuários em memória para autenticação básica via Spring Security.
 */
@Configuration
@EnableWebSecurity
public class ConfiguracoesSeguranca {

  @Bean
  public UserDetailsService userDetailsService() {
    // Criação do primeiro usuário com papel USER
    UserDetails user1 = User.builder()
        .username("ana@email.com")
        .password("{noop}ana123") // {noop} indica que a senha não está criptografada
        .roles("USER")
        .build();

    // Criação do segundo usuário com papel USER
    UserDetails user2 = User.builder()
        .username("leandro@email.com")
        .password("{noop}leandro123")
        .roles("USER")
        .build();

    // Registra ambos os usuários no gerenciador de autenticação em memória
    return new InMemoryUserDetailsManager(user1, user2);
  }

  // Bean responsável por configurar os filtros de segurança do Spring Security
  @Bean
  public SecurityFilterChain filtrosSeguranca(HttpSecurity http) throws Exception {

    return http
        // Define regras de autorização para requisições HTTP
        .authorizeHttpRequests(req -> {
          // Libera o acesso público a recursos estáticos como CSS, JS e imagens
          req.requestMatchers("/css/**", "/js/**", "/assets/**").permitAll();

          // Qualquer outra requisição exige autenticação (login)
          req.anyRequest().authenticated();
        })

        .build();
  }
}
