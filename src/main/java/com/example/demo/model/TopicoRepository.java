package com.forohub.repository;

import com.forohub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Método para encontrar un tópico por título y mensaje (para evitar duplicados)
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
}
