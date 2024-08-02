package sop.models;

public class AccountAPI {
	private int _id=0;
	private String _url="";
	private String _dayCreate="";
	public AccountAPI(int id, String url, String dayCreate) {
		super();
		this._id = id;
		this._url = url;
		this._dayCreate = dayCreate;
	}
	public AccountAPI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return _id;
	}
	public void setId(int _id) {
		this._id = _id;
	}
	public String getUrl() {
		return _url;
	}
	public void setUrl(String _url) {
		this._url = _url;
	}
	public String getDayCreate() {
		return _dayCreate;
	}
	public void setDayCreate(String _dayCreate) {
		this._dayCreate = _dayCreate;
	}
	
}
