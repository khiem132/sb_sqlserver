package sop.models;

public class UserLog {
	private String _id="";
	private String _user_id="";
	private String _time_log="";
	private int _minutes_token_mobile=10;
	private int _minutes_token_web=10;
	private String _webtoken="";
	private int _active=1;
	public UserLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLog(String id, String user_id, String time_log, int minutes_token_mobile,
			int minutes_token_web,
			String webtoken, int active) {
		super();
		this._id = id;
		this._user_id = user_id;
		this._time_log = time_log;
		this._minutes_token_mobile = minutes_token_mobile;
		this._minutes_token_web = minutes_token_web;
		this._webtoken = webtoken;
		this._active = active;
	}
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
	}
	public String getUser_id() {
		return _user_id;
	}
	public void setUser_id(String user_id) {
		this._user_id = user_id;
	}
	public String getTime_log() {
		return _time_log;
	}
	public void setTime_log(String time_log) {
		this._time_log = time_log;
	}
	public int getMinutes_token_mobile() {
		return _minutes_token_mobile;
	}
	public void setMinutes_token_mobile(int minutes_token_mobile) {
		this._minutes_token_mobile = minutes_token_mobile;
	}
	public int getMinutes_token_web() {
		return _minutes_token_web;
	}
	public void setMinutes_token_web(int minutes_token_web) {
		this._minutes_token_web = minutes_token_web;
	}
	public String getWebtoken() {
		return _webtoken;
	}
	public void setWebtoken(String webtoken) {
		this._webtoken = webtoken;
	}
	public int getActive() {
		return _active;
	}
	public void setActive(int active) {
		this._active = active;
	}
	
}
