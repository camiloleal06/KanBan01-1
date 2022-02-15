package org.kanban.services.impl;

import java.util.List;
import java.util.Optional;

import org.kanban.entities.Usuario;
import org.kanban.repository.UsuarioRepository;
import org.kanban.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

@Autowired
private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario save(Usuario usuario) {
	
		usuario.setPassword(new BCryptPasswordEncoder()
			          .encode(usuario.getPassword()));
            	 return usuarioRepository.save(usuario);
  	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Integer id) {
	return usuarioRepository.existsById(id);
	}

}
