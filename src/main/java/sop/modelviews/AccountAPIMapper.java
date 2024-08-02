package sop.modelviews;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sop.models.AccountAPI;
import sop.utils.Views;

public class AccountAPIMapper implements RowMapper<AccountAPI> {
	@Override
	public AccountAPI mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AccountAPI acc = new AccountAPI();
		acc.setId(rs.getInt(Views.COL_API_ID));
		acc.setUrl(rs.getString(Views.COL_API_URL));
		acc.setDayCreate(rs.getString(Views.COL_API_DAY_CREATE));
		return acc;
	}
}
