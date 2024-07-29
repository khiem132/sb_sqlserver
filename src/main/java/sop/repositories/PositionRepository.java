package sop.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sop.models.Position;
import sop.modelviews.PageView;
import sop.modelviews.Position_mapper;

//---------------------------
@Repository
public class PositionRepository {
	@Autowired
	JdbcTemplate db;// initialize object

	/***
	 * get all data from table tbl_position
	 * 
	 * @return list position
	 */

	public List<Position> findAll() {
		return db.query("select _id,isnull(_title,'') as _title,isnull(_status,0) as _status from tbl_position",
				new Position_mapper());
	}
	public List<Position> findAllPaging(PageView pageItem) {
		//get total_page
		int count=db.queryForObject("select count(*) from tbl_position ", Integer.class);
		int total_page=count/pageItem.getPage_size();
		pageItem.setTotal_page(total_page);
		//-----------
		return db.query("select _id,isnull(_title,'') as _title,isnull(_status,0) as _status "
				+ "from tbl_position order by _id desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY",
				new Position_mapper(),new Object[] {(pageItem.getPage_current()-1)*pageItem.getPage_size(),pageItem.getPage_size()});
	}

	public String newPosition(Position newItem) {
		try {
			int rowaccept = db.update("insert into tbl_position " + "values( ?, ?)",
					new Object[] { newItem.getTitle(), newItem.getStatus() });
			if (rowaccept == 1) {
				return "success";
			}
			return "failed";
		} catch (Exception e) {
			// TODO: handle exception
			// save exception to log database
		}
		return "insert exception data";
	}

	public String deletePosition(int id) {
		try {
			int rowaccept = db.update("delete from tbl_position where _id=?", new Object[] { id });
			if (rowaccept == 1) {
				return "success";
			}
			return "failed";
		} catch (Exception e) {
			// TODO: handle exception
			// save exception to log database

		}
		return "delete exception data";
	}

	public Position findById(int id) {
		return db.queryForObject("select * from tbl_position where _id=?", new Position_mapper(), new Object[] { id });
	}

	public String update(Position item) {
		try {
			int rowaccept = db.update("update tbl_position " + " set _title = ?, _status = ?" + " where _id = ?",
					new Object[] { item.getTitle(), item.getStatus(), item.getId() });
			if (rowaccept == 1) {
				return "success";
			}
			return "failed";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "update exception data";
	}

	public String updateStatus(int id, int status) {
		try {
			int rowaccept = db.update("update tbl_position " + " set _status = ?" + " where _id = ?",
					new Object[] { status, id });
			if (rowaccept == 1) {
				return "success";
			}
			return "failed";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "update exception data";
	}
}
