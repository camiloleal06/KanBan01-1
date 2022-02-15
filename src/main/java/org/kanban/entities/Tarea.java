package org.kanban.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tareas")
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descripcion;
	private LocalDate fechaejecucion;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Usuario usuario;
	
	
}