package sop.modelviews;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sop.models.UserLog;
import sop.utils.Views;

public class UserLog_mapper implements RowMapper<UserLog> {
	@Override
	public UserLog mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserLog ul = new UserLog();
		ul.setId(rs.getString(Views.COL_USER_LOG_ID));
		ul.setUser_id(rs.getString(Views.COL_USER_LOG_USER_ID));
		ul.setTime_log(rs.getString(Views.COL_USER_LOG_TIME_LOG));
		ul.setMinutes_token_mobile(rs.getInt(Views.COL_USER_LOG_MINUTES_TOKEN_MOBILE));
		ul.setMinutes_token_web(rs.getInt(Views.COL_USER_LOG_MINUTES_TOKEN_WEB));
		ul.setWebtoken(rs.getString(Views.COL_USER_LOG_WEB_TOKEN));
		ul.setActive(rs.getInt(Views.COL_USER_LOG_ACTIVE));
		return ul;
	}
}
