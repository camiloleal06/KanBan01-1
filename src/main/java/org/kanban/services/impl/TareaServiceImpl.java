package org.kanban.services.impl;

import java.util.List;
import java.util.Optional;

import org.kanban.dto.TareaUsuarioDTO;
import org.kanban.entities.Tarea;
import org.kanban.entities.Usuario;
import org.kanban.repository.TareaRepository;
import org.kanban.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TareaServiceImpl implements TareaService{

	@Autowired
	TareaRepository tareaRepository;

	@Override
	public Optional<Tarea> findByTitulo(String titulo) {
		return tareaRepository.findByTitulo(titulo);
	}

	@Override
	public List<Tarea> findAll() {
		return tareaRepository.findAll();
	}

	@Override
	public Page<Tarea> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea save(Tarea tarea) {
	return tareaRepository.save(tarea);
	}

	@Override
	public Optional<Tarea> findById(Integer id) {
	return tareaRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public List<Tarea> tareasUsuarioAutenticado(Usuario usuario) {
		// TODO Auto-generated method stub
		return tareaRepository.findByUsuario(usuario);
	}
	public List<TareaUsuarioDTO> listTareasDTO(int id){
		return tareaRepository.listaTareasByUsuario(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return false;
	}
}
