package org.kanban.services;

import java.util.List;
import java.util.Optional;

import org.kanban.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

	public List<Usuario> findAll();

	public Page<Usuario> findAll(Pageable pageable);

	public Usuario save(Usuario usuario);

	public Optional<Usuario> findById(Integer id);

	public boolean existsById(Integer id);

	public void delete(int id);
}
