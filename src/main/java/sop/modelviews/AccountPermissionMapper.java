package sop.modelviews;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sop.models.AccountPermission;
import sop.utils.Views;

public class AccountPermissionMapper implements RowMapper<AccountPermission> {
	@Override
	public AccountPermission mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AccountPermission ap = new AccountPermission();
		ap.setIdApi(rs.getInt(Views.COL_PERMISSION_ID_API));
		ap.setUserType(rs.getInt(Views.COL_PERMISSION_USER_TYPE));
		ap.setDayCreate(rs.getString(Views.COL_PERMISSION_DAY_CREATE));
		return ap;
	}
}
