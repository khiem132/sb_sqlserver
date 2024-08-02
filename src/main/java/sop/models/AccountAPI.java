package sop.models;

public class AccountAPI {
	private int _id=0;
	private String _url="";
	private String _dayCreate="";
	public AccountAPI(int _id, String _url, String _dayCreate) {
		super();
		this._id = _id;
		this._url = _url;
		this._dayCreate = _dayCreate;
	}
	public AccountAPI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String get_url() {
		return _url;
	}
	public void set_url(String _url) {
		this._url = _url;
	}
	public String get_dayCreate() {
		return _dayCreate;
	}
	public void set_dayCreate(String _dayCreate) {
		this._dayCreate = _dayCreate;
	}
	
}
