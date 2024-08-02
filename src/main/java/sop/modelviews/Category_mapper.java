package sop.modelviews;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sop.models.Category;
import sop.utils.FileUtility;
import sop.utils.Views;

public class Category_mapper  implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Category item=new Category();
		item.setId(rs.getInt(Views.COL_CATEGORY_ID));
		item.setTitle(rs.getNString(Views.COL_CATEGORY_TITLE));
		item.setImage(rs.getString(Views.COL_CATEGORY_IMAGE));
		item.setNo(rs.getInt(Views.COL_CATEGORY_NO));
		item.setIdType(rs.getInt(Views.COL_CATEGORY_ID_TYPE));
		item.setStatus(rs.getInt(Views.COL_CATEGORY_STATUS));
		item.setTypeTitle(rs.getNString(Views.COL_TYPE_TITLE));
		
		return item;
	}

}
