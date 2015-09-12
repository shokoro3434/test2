package com.eitax.recall.yahoo.dao;

import com.eitax.recall.yahoo.model.Category;
import java.util.List;

public interface YahooCategoryDAO {
	public Category save (Category category);
	public void deleteByYCategoryId(Integer yCategoryId);
	public List<Category> findByPath(String path);
}
