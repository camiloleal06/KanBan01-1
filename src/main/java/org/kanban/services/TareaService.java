package org.kanban.services;

import java.util.List;

import org.kanban.entities.Tarea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TareaService {

		public List<Tarea> findAll();

		public Page<Tarea> findAll(Pageable pageable);

		public void save(Tarea tarea);

		public Tarea findOne(Integer id);

		public void delete(Integer id);
		
		public boolean existsById(Integer id);
	
	   //	public List<ClienteDTO> listaClientes();
		
		//public Page<ClienteDTO> lista(Pageable pageable);
	}
