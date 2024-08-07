package sop.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.thymeleaf.expression.Objects;

import sop.models.UserLog;
import sop.modelviews.UserLog_mapper;
import sop.utils.JwtUtility;
import sop.utils.Views;

@Repository
public class UserLogRepository {
	@Autowired
	private JdbcTemplate db;
	
	public List<UserLog> getUserLogsByUserID(String userID){
		String str_query=String.format("select * from %s where %s=?", Views.TBL_USER_LOG,Views.COL_USER_LOG_USER_ID);
		return db.query(str_query,new UserLog_mapper(),new Object[] {userID});		
	}
	public UserLog getUserLogCurrentToken(String userID) {
		String str_query=String.format("select * from %s where %s=? and %s=1", Views.TBL_USER_LOG,
				Views.COL_USER_LOG_USER_ID,Views.COL_USER_LOG_ACTIVE);
		return db.queryForObject(str_query,new UserLog_mapper(),new Object[] {userID});
	}
	public UserLog newUserLogToken(String userID) {
		//update the last userlogtoken
		String str_update=String.format("update from %s set %s=0 where %s=?",
				Views.TBL_USER_LOG,
				Views.COL_USER_LOG_ACTIVE,
				Views.COL_USER_LOG_USER_ID);
		db.update(str_update,new Object[] {userID});
		String str_newItem=String.format("insert into %s(%s,%s,%s,%s,%s,%s) values(newid(),?,60,60,?,1)",
				Views.TBL_USER_LOG,
				Views.COL_USER_LOG_ID,
				Views.COL_USER_LOG_USER_ID,
				Views.COL_USER_LOG_MINUTES_TOKEN_MOBILE,
				Views.COL_USER_LOG_MINUTES_TOKEN_WEB,
				Views.COL_USER_LOG_WEB_TOKEN,
				Views.COL_USER_LOG_ACTIVE);
		JwtUtility mytoken=new JwtUtility();
		UserLog ul=new UserLog();
		ul.setUser_id(userID);
		ul.setActive(1);		
		ul.setWebtoken(mytoken.generateToken());
		db.update(str_newItem,new Object[] {ul.getUser_id(),ul.getWebtoken()});
		return ul;
	}
}
