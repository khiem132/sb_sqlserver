package sop.modelviews;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sop.models.Category;

public class Category_mapper  implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
