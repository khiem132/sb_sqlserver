package sop.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import sop.models.UserAccount;
import sop.models.UserLog;
import sop.modelviews.UserAccount_mapper;
import sop.utils.Views;

@Repository
public class UserAccountRepository {
	@Autowired
	private JdbcTemplate db;
	@Autowired
	private UserLogRepository ulr;

	public List<UserAccount> findAll() {
		String str_query = String.format("select * from %s", Views.TBL_USER);
		return db.query(str_query, new UserAccount_mapper());
	}

	public UserAccount findById(String id) {
		String str_query = String.format("select * from %s where %s=?", Views.TBL_USER, Views.COL_USER_ID);
		return db.queryForObject(str_query, new UserAccount_mapper(), new Object[] { id });
	}

	public String newUserAccount(UserAccount new_item) {
		SimpleJdbcCall simpleCall = new SimpleJdbcCall(db).withProcedureName("sp_new_user");
		SqlParameterSource params = new MapSqlParameterSource().addValue("name", new_item.getName())
				.addValue("email", new_item.getEmail()).addValue("phone", new_item.getPhone())
				.addValue("address", new_item.getAddress()).addValue("username", new_item.getUsername())
				.addValue("pass", new_item.getPassword());
		try {
			Map out = simpleCall.execute(params);
			if (out != null) {
				return (String) out.get("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			 System.err.println(e.getMessage());
		}
		return "";
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return userlog after check account login success
	 */

	public UserLog checkAccount(String userName, String password) {
		String str_query = String.format("select _id from %s where %s=? and %s=?", Views.TBL_USER,
				Views.COL_USER_USERNAME, Views.COL_USER_PASSWORD);
		// add new web token
		String _user_id = db.queryForObject(str_query, String.class, new Object[] { userName, password });
		if (_user_id.isEmpty() == false) {
			UserLog ul = ulr.getUserLogCurrentToken(_user_id);
			return ul;
		}
		return null;
	}
}
