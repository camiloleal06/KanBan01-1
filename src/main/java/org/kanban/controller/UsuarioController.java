package org.kanban.controller;

import java.util.List;

import org.kanban.entities.Usuario;
import org.kanban.services.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@PreAuthorize("authenticated")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl usuarioServiceImpl;
	
	@PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
	@GetMapping("usuario")
	public ResponseEntity<List<Usuario>> ListarUsuarios (){
	  try {
			return new ResponseEntity<List<Usuario>>(usuarioServiceImpl.findAll(), HttpStatus.OK);
		}
	  catch(Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("usuario")
	public ResponseEntity<?> createUsuario(@RequestBody Usuario user) {
		return new ResponseEntity<>(usuarioServiceImpl.save(user), HttpStatus.CREATED);
	}
	
	
	@GetMapping("usuario/{id}")
	public ResponseEntity<?> findUsuarioById(@PathVariable("id") int id){
		return new ResponseEntity<>(usuarioServiceImpl.findById(id).orElse(null), HttpStatus.NOT_FOUND);
		
	}
	/*
	@PutMapping("/usuario/{id}")
	public Usuario editUsuario(@RequestBody Usuario usuario, @PathVariable int id) {
		if (usuarioServiceImpl.existsById(id)) {
			usuario.setId(id);
			return usuarioServiceImpl.save(usuario);
		} else {
			return null;
		}
	}*/
}
