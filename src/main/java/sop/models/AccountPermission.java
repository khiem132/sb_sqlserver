package sop.models;

public class AccountPermission {
	private int _user_type=0;
	private int _id_api=0;
	private String _dayCreate="";
	public AccountPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountPermission(int user_type, int id_api, String dayCreate) {
		super();
		this._user_type = user_type;
		this._id_api = id_api;
		this._dayCreate = dayCreate;
	}
	public int getUserType() {
		return _user_type;
	}
	public void setUserType(int user_type) {
		this._user_type = user_type;
	}
	public int getIdApi() {
		return _id_api;
	}
	public void setIdApi(int id_api) {
		this._id_api = id_api;
	}
	public String getDayCreate() {
		return _dayCreate;
	}
	public void setDayCreate(String dayCreate) {
		this._dayCreate = dayCreate;
	}
	
}
