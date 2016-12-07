package fr.icdc.dei.todolist.service;

import java.util.Date;
import java.util.List;
import fr.icdc.dei.todolist.persistence.entity.Task;

public interface TaskService {

	List<Task> list();

	Task add(Task task);

	boolean isEnded(Task task);


	Task find(long id);

	boolean expectedEndIsInInterval(Task task, Date beginningDate, Date endingDate);

	List<Task> listNotEndedInIntervalOfUser(long idUser, Date beginningDate, Date endingDate);
}
