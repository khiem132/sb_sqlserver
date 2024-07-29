package sop.repositories;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sop.models.Category;
import sop.models.Position;
import sop.modelviews.Category_mapper;
import sop.modelviews.Position_mapper;
import sop.utils.FileUtility;
import sop.utils.Views;

@Repository
public class CategoryRepository {
	@Autowired
	JdbcTemplate db;// initialize object

	public List<Category> findAll() {
		String str_query = String.format("select c.*,t.%s from %s c, %s t where c.%s=t.%s", Views.COL_TYPE_TITLE,
				Views.TBL_CATEGORY, Views.TBL_TYPE, Views.COL_CATEGORY_ID_TYPE, Views.COL_TYPE_ID);
		return db.query(str_query, new Category_mapper());
	}

	public String newCategory(Category newItem) {
		try {
			String str_query = String.format("insert into %s values(?,?,?,?,?)", Views.TBL_CATEGORY);
			int rowaccept = db.update(str_query, new Object[] { newItem.getTitle(), newItem.getImage(), newItem.getNo(),
					newItem.getIdType(), newItem.getStatus() });
			if (rowaccept == 1) {
				return "success";
			}
			return "failed";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "insert exception data";
	}

	public Category findById(int id) {
		String str_query = String.format("select * from %s where %s=?", Views.TBL_CATEGORY, Views.COL_CATEGORY_ID);
		return db.queryForObject(str_query, new Category_mapper(), new Object[] { id });
	}

	public String deleteCategory(int id) {
		String str_query = String.format("delete from %s where %s=?", Views.TBL_CATEGORY, Views.COL_CATEGORY_ID);
		Category cateItemDel=findById(id);		
		try {
			int rowaccept = db.update(str_query, new Object[] { id });
			if (rowaccept == 1) {
				FileUtility.deleteFile("uploads", cateItemDel.getImage());
				return "success";
			}
			return "failed";
		} catch (Exception e) {
			// TODO: handle exception
			// save exception to log database

		}
		return "delete exception data";
	}
}
