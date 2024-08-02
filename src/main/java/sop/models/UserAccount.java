package sop.models;

public class UserAccount {
	private String _id="";
	private String _name="";
	private String _email="";
	private String _phone="";
	private String _address="";
	private String _username="";
	private String _password="";
	private String _cart="";
	private int _status=1;
	private int _user_type=0;
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAccount(String id, String name, String email, String phone, 
			String address, String username,
			String password, String cart, int status, int user_type) {
		super();
		this._id = id;
		this._name = name;
		this._email = email;
		this._phone = phone;
		this._address = address;
		this._username = username;
		this._password = password;
		this._cart = cart;
		this._status = status;
		this._user_type = user_type;
	}
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
	}
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}
	public String getEmail() {
		return _email;
	}
	public void setEmail(String email) {
		this._email = email;
	}
	public String getPhone() {
		return _phone;
	}
	public void setPhone(String phone) {
		this._phone = phone;
	}
	public String getAddress() {
		return _address;
	}
	public void setAddress(String address) {
		this._address = address;
	}
	public String getUsername() {
		return _username;
	}
	public void setUsername(String username) {
		this._username = username;
	}
	public String getPassword() {
		return _password;
	}
	public void setPassword(String password) {
		this._password = password;
	}
	public String getCart() {
		return _cart;
	}
	public void setCart(String cart) {
		this._cart = cart;
	}
	public int getStatus() {
		return _status;
	}
	public void setStatus(int status) {
		this._status = status;
	}
	public int getUser_type() {
		return _user_type;
	}
	public void setUser_type(int user_type) {
		this._user_type = user_type;
	}
	
}
