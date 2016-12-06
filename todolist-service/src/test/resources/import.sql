-- TaskServiceTest
-- testlistThreeLastTasks
-- ID_ACCOUNT_TYPE = 1L
INSERT INTO TA_ACCOUNT_TYPE(label) VALUES('FREE');
-- ID_USER = 1L
INSERT INTO user(name, USER_TYPE) VALUES('testNameUser', 'USER_FREE')
-- ID_CATEGORY = 1L
INSERT INTO category(name) VALUES('testNameCategory')
-- ID_TASK = 1L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask1DB', 1);
-- ID_TASK = 2L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask2DB', 1);
-- ID_TASK = 3L
INSERT INTO task(label, id_user) VALUES('testFind3lastTask3DB', 1);
-- testAddTaskWithLessThanTenTasksForFreeUser
-- ID_USER = 2L
INSERT INTO user(name, USER_TYPE) VALUES('AddTaskWithLessThanTenTasksForFreeUser', 'USER_FREE')
--ID_TASK = 4L
INSERT INTO task(label,id_user,endingDate) VALUES('testFinishedTask',  1,  '2010-04-02 15:28:22' );
--ID_TASK = 5L
INSERT INTO task(label,id_user) VALUES('testNotFinishedTask',  1);


--testUserHasNotEndedTask
-- ID_USER = 3L
INSERT INTO user(name, USER_TYPE) VALUES('userWithNotEndedTasks', 'USER_FREE')
--ID_TASK = 6L
INSERT INTO task(label,id_user) VALUES('testNotFinishedTask',  3);