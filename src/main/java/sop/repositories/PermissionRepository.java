package sop.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionRepository {
	@Autowired
	JdbcTemplate db;
	public String newAPI(String urlApi) {
		String str_query=String.format("insert into %s", null)
	}
}
