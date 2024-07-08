package sop.modelviews;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sop.models.Position;
import sop.models.TypeCategory;
import sop.utils.Views;

public class Type_mapper implements RowMapper<TypeCategory> {

	@Override
	public TypeCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TypeCategory item = new TypeCategory();
		item.setId(rs.getInt(Views.COL_TYPE_ID));
		item.setTitle(rs.getString(Views.COL_TYPE_TITLE));		
		return item;
	}

}
