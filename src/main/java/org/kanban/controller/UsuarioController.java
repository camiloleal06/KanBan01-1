package org.kanban.controller;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.kanban.dto.TareaUsuarioDTO;
import org.kanban.entities.Usuario;
import org.kanban.services.impl.TareaServiceImpl;
import org.kanban.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

	private final String TAREA = "/tarea";
	private final String ID = "/{id}";
	private final String USER_ID = "/{user_id}";
	private final String TITULO = "/{titulo}";
	private final String USUARIO = "usuario";

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	@Autowired
	TareaServiceImpl tareaServiceImpl;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(USUARIO)
	public ResponseEntity<List<Usuario>> ListarUsuarios() {
		try {
			return new ResponseEntity<List<Usuario>>(usuarioServiceImpl.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(USUARIO)
	public ResponseEntity<?> createUsuario(@RequestBody Usuario user) {
		return new ResponseEntity<>(usuarioServiceImpl.save(user), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	@GetMapping(USUARIO + ID)
	public ResponseEntity<?> findUsuarioById(@PathVariable("id") int id) {
		return new ResponseEntity<>(usuarioServiceImpl.findById(id).orElse(null), HttpStatus.NOT_FOUND);
	}

	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	@GetMapping(USUARIO + TAREA + USER_ID)
	public ResponseEntity<?> findUsuarioTareaByUserId(@PathVariable("user_id") int user_id) {
		return new ResponseEntity<>(tareaServiceImpl.listTareasDTO(user_id), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(USUARIO + ID)
	public ResponseEntity<?> eliminarUsuarioById(@PathVariable("id") int id) {
    	if (!usuarioServiceImpl.existsById(id))
			return new ResponseEntity("El usuario con ID " + id + " no existe", HttpStatus.NOT_FOUND);
		usuarioServiceImpl.delete(id);
		    return new ResponseEntity("Usuario eliminado", HttpStatus.OK);
	}
}