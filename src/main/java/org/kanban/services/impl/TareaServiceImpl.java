package org.kanban.services.impl;

import java.util.List;

import org.kanban.entities.Tarea;
import org.kanban.services.TareaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TareaServiceImpl implements TareaService{

	@Override
	public List<Tarea> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Tarea> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Tarea tarea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tarea findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
