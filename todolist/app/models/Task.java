package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Task extends Model {

	private boolean concluido = false;
	
	@Id
	public Long id;

	@Required
	public String label;
	
	@Required
	public String projeto;
	
	@Required
	public int prioridade;

	public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);

	public static List<Task> all() {
		return find.all();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public static void create(Task task) {
		task.save();
	}
	
	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	public static void update(Long id) {
		Task task = find.ref(id);
		if (task.isConcluido() == true) {
			task.setConcluido(false);
		} else {
			task.setConcluido(true);
		}
		task.update();
	}

	public boolean isConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

}