package fr.icdc.dei.todolist.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.icdc.dei.todolist.persistence.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
