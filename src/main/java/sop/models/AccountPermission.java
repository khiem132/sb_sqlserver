package sop.models;

public class AccountPermission {
	private int _user_type=0;
	private int _id_api=0;
	private String _dayCreate="";
	public AccountPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountPermission(int _user_type, int _id_api, String _dayCreate) {
		super();
		this._user_type = _user_type;
		this._id_api = _id_api;
		this._dayCreate = _dayCreate;
	}
	public int get_user_type() {
		return _user_type;
	}
	public void set_user_type(int _user_type) {
		this._user_type = _user_type;
	}
	public int get_id_api() {
		return _id_api;
	}
	public void set_id_api(int _id_api) {
		this._id_api = _id_api;
	}
	public String get_dayCreate() {
		return _dayCreate;
	}
	public void set_dayCreate(String _dayCreate) {
		this._dayCreate = _dayCreate;
	}
	
}
