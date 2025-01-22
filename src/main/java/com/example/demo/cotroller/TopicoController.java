package com.forohub.controller;

import com.forohub.model.Topico;
import com.forohub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/forohub")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    // Endpoint para crear un nuevo tópico
    @PostMapping("/topicos")
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico nuevoTopico) {
        Optional<Topico> topicoExistente = topicoService.buscarTopicoPorTituloYMensaje(
                nuevoTopico.getTitulo(), nuevoTopico.getMensaje());

        if (topicoExistente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Tópico duplicado
        }

        Topico topico = topicoService.guardarTopico(nuevoTopico);
        return new ResponseEntity<>(topico, HttpStatus.CREATED);
    }

    // Endpoint para listar todos los tópicos
    @GetMapping("/topicos")
    public ResponseEntity<List<Topico>> obtenerTodosLosTopicos() {
        List<Topico> topicos = topicoService.obtenerTodosLosTopicos();
        return new ResponseEntity<>(topicos, HttpStatus.OK);
    }

    // Endpoint para actualizar un tópico
    @PutMapping("/topicos/{id}")
    public ResponseEntity<Topico> actualizarTopico(
            @PathVariable Long id, @RequestBody @Valid Topico topicoActualizado) {

        Optional<Topico> topicoExistente = topicoService.buscarTopicoPorId(id);

        if (!topicoExistente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Tópico no encontrado
        }

        // Verificar duplicados
        Optional<Topico> topicoDuplicado = topicoService.buscarTopicoPorTituloYMensaje(
                topicoActualizado.getTitulo(), topicoActualizado.getMensaje());

        if (topicoDuplicado.isPresent() && !topicoDuplicado.get().getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Tópico duplicado
        }

        Topico topico = topicoExistente.get();
        topico.setTitulo(topicoActualizado.getTitulo());
        topico.setMensaje(topicoActualizado.getMensaje());
        topico.setAutor(topicoActualizado.getAutor());
        topico.setCurso(topicoActualizado.getCurso());

        topicoService.guardarTopico(topico);

        return new ResponseEntity<>(topico, HttpStatus.OK);
    }

    // Endpoint para eliminar un tópico
    @DeleteMapping("/topicos/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {

        Optional<Topico> topicoExistente = topicoService.buscarTopicoPorId(id);

        if (!topicoExistente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Tópico no encontrado
        }

        topicoService.eliminarTopico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Eliminación exitosa
    }
}
