package fr.icdc.dei.todolist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.icdc.dei.todolist.persistence.dao.CategoryDao;
import fr.icdc.dei.todolist.persistence.entity.Category;
import fr.icdc.dei.todolist.service.CategoryService;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> list() {
		return categoryDao.findAll();
	}

}
