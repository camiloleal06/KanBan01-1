package org.kanban.controller;

import org.kanban.entities.Tarea;
import org.kanban.entities.Usuario;
import org.kanban.services.impl.TareaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("authenticated")
@RestController
public class TareaController {

    @Autowired
    private TareaServiceImpl tareaServiceImpl;
    private final String TAREA ="tarea";
    private final String ID ="/{id}";
    private final String TITULO ="/{titulo}";

  /*  @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(TAREA)
    public ResponseEntity<List<Tarea>> ListarTareas(){
        try {
            return new ResponseEntity<List<Tarea>>(tareaServiceImpl.findAll(), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
      }*/
  @GetMapping(TAREA)
  public ResponseEntity<List<Tarea>> ListarTareas(@AuthenticationPrincipal Usuario usuario) {
      List<Tarea> tareas = tareas = tareaServiceImpl.tareasUsuarioAutenticado(usuario);
      return new ResponseEntity<List<Tarea>>(tareas, HttpStatus.OK);

  }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(TAREA)
    public ResponseEntity<?> createTarea(@RequestBody Tarea tarea) {
        return new ResponseEntity<>(tareaServiceImpl.save(tarea), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    @GetMapping(TAREA+TITULO)
    public ResponseEntity<?> findTareaByTitulo(@PathVariable("titulo") String titulo){
        return new ResponseEntity<>(tareaServiceImpl.findByTitulo(titulo)
                .orElse(null), HttpStatus.NOT_FOUND);
    }

}
