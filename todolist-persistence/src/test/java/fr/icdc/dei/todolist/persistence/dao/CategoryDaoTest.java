package fr.icdc.dei.todolist.persistence.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.icdc.dei.todolist.persistence.entity.Category;

public class CategoryDaoTest extends AbstractDaoTest {

	private static final String TEST_UPDATE_CATEGORY_RIGHT_NAME_DB = "testUpdateCategoryRightNameDB";
	private static final long UPDATE_CATEGORY_RIGHT_NAME_ID = 3L;
	private static final long UPDATE_CATEGORY_NAME_HAS_CHANGE_ID = 2L;
	private static final String TEST_UPDATE_CATEGORY_CHANGED_NAME_DB = "testUpdateCategoryChangedNameDB";
	private static final String TEST_UPDATE_NEW_CATEGORY_NAME_DB = "testUpdateNewCategoryNameDB";
	private static final String TEST_FIND_CATEGORY_NAME_DB = "testFindCategoryNameDB";

	@Autowired
	private CategoryDao categoryDao;
	
	private static final Category category = new Category();
	private static final long ID_CATEGORY_TO_FIND = 1L;

	@Test
	public void testCreateCategory() {
		assertNotNull(categoryDao.save(category));
	}
	
	@Test
	public void testFindCategoryIsNotNull() {
		assertNotNull(categoryDao.findOne(ID_CATEGORY_TO_FIND));
	}
	
	@Test
	public void testFindCategory() {
		assertEquals(categoryDao.findOne(ID_CATEGORY_TO_FIND).getName(), TEST_FIND_CATEGORY_NAME_DB);
	}
	
	@Test
	public void testUpdateCategoryHasNameChanged() {
		category.setId(UPDATE_CATEGORY_NAME_HAS_CHANGE_ID);
		category.setName(TEST_UPDATE_NEW_CATEGORY_NAME_DB);
		assertNotEquals(categoryDao.save(category).getName(), TEST_UPDATE_CATEGORY_CHANGED_NAME_DB);
	}
	
	@Test
	public void testUpdateCategoryHasRightName() {
		category.setId(UPDATE_CATEGORY_RIGHT_NAME_ID);
		category.setName(TEST_UPDATE_CATEGORY_RIGHT_NAME_DB);
		assertEquals(categoryDao.save(category).getName(), TEST_UPDATE_CATEGORY_RIGHT_NAME_DB);
	}

}
