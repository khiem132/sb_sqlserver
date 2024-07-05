package sop.models;

import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;

public class Position {
	private  int id;// field
	private  String title;
	private  int status;
	public Position() {
		this.id = 0;
		this.title = "";
		this.status = 0;
	
		// TODO Auto-generated constructor stub
	}
	@JsonCreator	 
	public Position( int id, String title,
			 int status) {
		super();
		// TODO Auto-generated constructor stub
		this.id =id;
		this.title = title;
		this.status = status;
	}
	// property :Id
	public int getId() {
		return this.id;
	}
	public void setId(int _id) {
		this.id = _id;
	}
	// ---------
	// property: Title
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String _title) {
		this.title = _title;
	}

	// ---------
	// property:Status
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int _status) {
		this.status = _status;
	}
	// ---------
}
