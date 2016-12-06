package fr.icdc.dei.todolist.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.icdc.dei.todolist.persistence.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{

}
