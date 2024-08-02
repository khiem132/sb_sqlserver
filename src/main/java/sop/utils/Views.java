package sop.utils;

public final class Views {
	public static String POSITION_INDEX = "position/index";
	public static String POSITION_CREATE = "position/input_position";
	public static String POSITION_EDIT = "position/edit_position";
	public static String TYPE_INDEX="types/index";
	public static String TYPE_CREATE="types/new_type";
	public static String TYPE_EDIT="types/edit_type";
	public static String CATEGORY_CREATE="categories/new_category";
	public static String CATEGORY_INDEX="categories/index";
	// region position
	public static String TBL_POSITION = "tbl_position";
	public static String COL_POSITION_ID = "_id";
	public static String COL_POSITION_TITLE = "_title";
	public static String COL_POSITION_STATUS = "_status";
	// end region
	//region type
	public static String TBL_TYPE="tbl_type";
	public static String COL_TYPE_ID="_id";
	public static String COL_TYPE_TITLE="_title";	
	//end region
	//region category
	public static String TBL_CATEGORY="tbl_category";
	public static String COL_CATEGORY_ID="_id";
	public static String COL_CATEGORY_TITLE="_title";	
	public static String COL_CATEGORY_IMAGE="_image";
	public static String COL_CATEGORY_NO="_no";
	public static String COL_CATEGORY_ID_TYPE="_id_type";
	public static String COL_CATEGORY_STATUS="_status";
	//end region
	//region UserAccount
	public static String TBL_USER="tbl_user";
	public static String COL_USER_ID="_id";
	public static String COL_USER_NAME="_name";
	public static String COL_USER_EMAIL="_email";
	public static String COL_USER_PHONE="_phone";
	public static String COL_USER_ADDRESS="_address";
	public static String COL_USER_USERNAME="_username";
	public static String COL_USER_PASSWORD="_password";
	public static String COL_USER_CART="_cart";
	public static String COL_USER_STATUS="_status";
	public static String COL_USER_USERTYPE="_user_type";
	//end region
	//region UserLog
	public static String TBL_USER_LOG="tbl_user_log";
	public static String COL_USER_LOG_ID="_id";
	public static String COL_USER_LOG_USER_ID="_user_id";
	public static String COL_USER_LOG_TIME_LOG="_time_log";
	public static String COL_USER_LOG_MINUTES_TOKEN_MOBILE="_minutes_token_mobile";
	public static String COL_USER_LOG_MINUTES_TOKEN_WEB="_minutes_token_web";
	public static String COL_USER_LOG_WEB_TOKEN="_web_token";
	public static String COL_USER_LOG_ACTIVE="_active";
	//end region
	//region table api
	public static String TBL_API="tbl_api";
	public static String COL_API_ID="_id";
	public static String COL_API_URL="_url";
	public static String COL_API_DAY_CREATE="_day_create";
	//end region
	//region table permission
	public static String TBL_PERMISSION="tbl_permission";
	public static String COL_PERMISSION_USER_TYPE="_user_type";
	public static String COL_PERMISSION_ID_API="_id_api";
	public static String COL_PERMISSION_DAY_CREATE="_day_create";
	//end region
}
