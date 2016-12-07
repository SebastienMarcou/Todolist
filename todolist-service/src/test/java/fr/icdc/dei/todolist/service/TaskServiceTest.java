package fr.icdc.dei.todolist.service;

import static org.junit.Assert.*;

import org.apache.commons.collections.CollectionUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Task;
import fr.icdc.dei.todolist.persistence.entity.User;
import fr.icdc.dei.todolist.persistence.entity.UserFree;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TaskServiceTest extends AbstractServiceTest {

	private static final String TASK_LABEL = "taskLabel";

	private final static Task task = new Task();
	private final static User user = new UserFree();
	public static final long ID_TASK_NOT_ENDED = 8L;
	public static final long ID_TASK_ENDED = 7L;
	public static final long ID_USER = 4L;
	public static Date BEGINNING_DATE;
	public static Date ENDING_DATE;




	@Autowired
	private TaskService taskService;
	
	@BeforeClass
	public static void setUp() {
		task.setLabel(TASK_LABEL);
		user.setId(2L);
		task.setUser(user);
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.set(2012,10,10);
		BEGINNING_DATE = calendar.getTime();
		calendar.set(2016, 10,11);
		ENDING_DATE = calendar.getTime();

	}

	@Test
	public void testListTasks() {
		assertTrue(CollectionUtils.isNotEmpty(taskService.list()));
	}
	
	@Test
	public void testAddTaskSucceedWithLessThanTenTasksForFreeUser() {
		assertNotNull(taskService.add(task));
	}
	@Test
	public void testEndedTaskisEnded(){
		assertTrue(taskService.isEnded(taskService.find(ID_TASK_ENDED)));
		
	}

	@Test
	public void testNotEndedTaskisNotEnded(){
		assertFalse(taskService.isEnded(taskService.find(ID_TASK_NOT_ENDED)));
	}

	@Test
	public void testTaskExpectedEndInInterval(){

		assertTrue(taskService.expectedEndIsInInterval(taskService.find(9L),BEGINNING_DATE,ENDING_DATE));
	}
	@Test
	public void testTaskListNotEndedHasTask(){
		assertFalse(taskService.listNotEndedInIntervalOfUser(ID_USER,BEGINNING_DATE,ENDING_DATE).isEmpty());


	}



}
