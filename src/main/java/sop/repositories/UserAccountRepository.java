package sop.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sop.models.UserAccount;
import sop.modelviews.UserAccount_mapper;
import sop.utils.Views;

@Repository
public class UserAccountRepository {
	@Autowired
	private JdbcTemplate db;

	public List<UserAccount> findAll() {
		String str_query = String.format("select * from %s", Views.TBL_USER);
		return db.query(str_query, new UserAccount_mapper());
	}

	public UserAccount findById(String id) {
		String str_query = String.format("select * from %s where %s=?", Views.TBL_USER, Views.COL_USER_ID);
		return db.queryForObject(str_query, new UserAccount_mapper(), new Object[] { id });
	}

	public String checkAccount(String userName, String password) {
		String str_query = String.format("select _id from %s where %s=? and %s=?", Views.TBL_USER,
				Views.COL_USER_USERNAME, Views.COL_USER_PASSWORD);
		return db.queryForObject(str_query, String.class, new Object[] { userName, password });
	}
}
