package com.forohub.service;

import com.forohub.model.Topico;
import com.forohub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    // Obtener todos los tópicos
    public List<Topico> obtenerTodosLosTopicos() {
        return topicoRepository.findAll();
    }

    // Buscar tópico por ID
    public Optional<Topico> buscarTopicoPorId(Long id) {
        return topicoRepository.findById(id);
    }

    // Buscar un tópico por título y mensaje para comprobar duplicados
    public Optional<Topico> buscarTopicoPorTituloYMensaje(String titulo, String mensaje) {
        return topicoRepository.findByTituloAndMensaje(titulo, mensaje);
    }

    // Guardar un tópico
    public Topico guardarTopico(Topico topico) {
        return topicoRepository.save(topico);
    }

    // Eliminar un tópico por ID
    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }
}
