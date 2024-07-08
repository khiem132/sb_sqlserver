package sop.models;

public class TypeCategory {
	private int _id;
	private String _title;

	public TypeCategory() {
		// TODO Auto-generated constructor stub
		this._id = 0;
		this._title = "";
	}

	public TypeCategory(int newId, String newTitle) {
		this._id = newId;
		this._title = newTitle;
	}

	public int getId() {
		return this._id;
	}

	public void setId(int newId) {
		this._id = newId;
	}

	public String getTitle() {
		return this._title;
	}

	public void setTitle(String newTitle) {
		this._title = newTitle;
	}

}
