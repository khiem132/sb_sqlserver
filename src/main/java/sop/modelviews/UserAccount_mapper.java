package sop.modelviews;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sop.models.UserAccount;
import sop.utils.Views;

public class UserAccount_mapper implements RowMapper<UserAccount> {

	@Override
	public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserAccount acc=new UserAccount();
		acc.setId(rs.getString(Views.COL_USER_ID));
		acc.setName(rs.getString(Views.COL_USER_NAME));
		acc.setEmail(rs.getString(Views.COL_USER_EMAIL));
		acc.setPhone(rs.getString(Views.COL_USER_PHONE));
		acc.setAddress(rs.getString(Views.COL_USER_ADDRESS));
		acc.setUsername(rs.getString(Views.COL_USER_USERNAME));
		acc.setPassword(rs.getString(Views.COL_USER_PASSWORD));
		acc.setCart(rs.getString(Views.COL_USER_CART));
		acc.setStatus(rs.getInt(Views.COL_USER_STATUS));
		acc.setUser_type(rs.getInt(Views.COL_USER_USERTYPE));		
		return acc;
	}

}
