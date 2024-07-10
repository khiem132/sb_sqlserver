package sop.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sop.models.Position;
import sop.models.TypeCategory;
import sop.modelviews.PageView;
import sop.modelviews.Type_mapper;
import sop.utils.Views;

@Repository
public class TypeRepository {
	@Autowired
	JdbcTemplate db;// initialize object

	public List<TypeCategory> findAll() {
		String str_query = String.format("select %s, %s from %s", Views.COL_TYPE_ID, Views.COL_TYPE_TITLE,
				Views.TBL_TYPE);
		return db.query(str_query, new Type_mapper());
	}

	public List<TypeCategory> findAllPaging(PageView pageItem) {
		// get total_page
		String str_query_counter = String.format("select count(*) from %s", Views.TBL_TYPE);
		int count = db.queryForObject(str_query_counter, Integer.class);
		int total_page = count / pageItem.getPage_size();
		pageItem.setTotal_page(total_page);
		// -----------
		String str_query_type = String.format(
				"select %s,%s from %s order by %s desc offset ? rows fetch next ? rows only", Views.COL_TYPE_ID,
				Views.COL_TYPE_TITLE, Views.TBL_TYPE, Views.COL_TYPE_ID);
		return db.query(str_query_type, new Type_mapper(),
				new Object[] { (pageItem.getPage_current() - 1) * pageItem.getPage_size(), pageItem.getPage_size() });
	}
	public String newType(TypeCategory newItem) {
		try {
			String str_query=String.format("insert into %s values( ?)", Views.TBL_TYPE) ;
			int rowaccept = db.update(str_query,
					new Object[] { newItem.getTitle() });
			if (rowaccept == 1) {
				return "success";
			}
			return "failed";
		} catch (Exception e) {
			// TODO: handle exception
			// save exception to log database
		}
		return "insert exception data";
	}
	public String deleteType(int id) {
		try {
			String strquery=String.format("delete from %s where _id=?", Views.TBL_TYPE);
			int rowaccept = db.update(strquery, new Object[] { id });
			if (rowaccept == 1) {
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
