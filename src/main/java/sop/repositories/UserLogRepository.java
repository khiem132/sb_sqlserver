package sop.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sop.models.UserLog;
import sop.modelviews.UserLog_mapper;
import sop.utils.Views;

@Repository
public class UserLogRepository {
	@Autowired
	private JdbcTemplate db;
	
	public List<UserLog> getUserLogsByUserID(String userID){
		String str_query=String.format("select * from %s where %s=?", Views.TBL_USER_LOG,Views.COL_USER_LOG_USER_ID);
		return db.query(str_query,new UserLog_mapper(),new Object[] {userID});		
	}
	public String getUserLogCurrentToken(String userID) {
		String str_query=String.format("select %s from %s where %s=? and %s=1", Views.COL_USER_LOG_WEB_TOKEN,Views.TBL_USER_LOG,
				Views.COL_USER_LOG_USER_ID,Views.COL_USER_LOG_ACTIVE);
		return db.queryForObject(str_query,String.class,new Object[] {userID});
	}
}
