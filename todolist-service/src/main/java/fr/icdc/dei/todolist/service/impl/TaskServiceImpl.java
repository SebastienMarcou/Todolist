package fr.icdc.dei.todolist.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icdc.dei.todolist.persistence.dao.TaskDao;
import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.service.TaskService;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public List<Task> list() {
		return taskDao.findAll();
	}

	@Override
	public Task add(Task task) {
		if(task.getUser().getTasks().size() < 10)
			return taskDao.save(task);
		return null;
	}

	@Override
	public boolean isEnded(Task task) {

		return task.getEndingDate()!= null;
	}

	@Override
	public Task find(long id) {
		return taskDao.findOne(id);
	}

	@Override
	public boolean expectedEndIsInInterval(Task task, Date beginningDate, Date endingDate) {
		return task.getEndingDate().compareTo(beginningDate) >= 0 && task.getEndingDate().compareTo(endingDate) <= 0;
	}

	@Override
	public List<Task> listNotEndedInIntervalOfUser(long idUser, Date beginningDate, Date endingDate) {
		List<Task> tasksUser =  taskDao.findAllByUserId(idUser);
		List<Task> validTask = new ArrayList<Task>();

		for(Task task : tasksUser){
			if(!isEnded(task) && expectedEndIsInInterval(task,beginningDate,endingDate)){

				validTask.add(task);
			}

		}
		return  validTask;

	}

}
