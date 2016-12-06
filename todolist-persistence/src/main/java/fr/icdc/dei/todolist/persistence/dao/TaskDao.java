package fr.icdc.dei.todolist.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TaskDao extends JpaRepository<Task, Long>{

	Task findByLabel(String label);

	List<Task> findAllByUserIdAndCategoryId(long idUser, long idCategory);


}
