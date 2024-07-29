package sop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sop.models.Position;
import sop.modelviews.PageView;
import sop.repositories.PositionRepository;
import sop.utils.Views;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/position")
public class PositionController {

	@Autowired
	PositionRepository rep;

	@GetMapping("")
	public String index(Model model, @RequestParam(name = "cp", required = false, defaultValue = "1") int cp) {
		PageView pv = new PageView();
		pv.setPage_current(cp);
		pv.setPage_size(50);
		model.addAttribute("positions", rep.findAllPaging(pv));
		model.addAttribute("pv", pv);
		return Views.POSITION_INDEX;
	}

	@GetMapping("/create")
	public String input_position(Model model) {
		Position p = new Position();
		p.setTitle("");
		p.setStatus(0);
		model.addAttribute("new_item", p);
		return Views.POSITION_CREATE;
	}

	@PostMapping("/newposition")
	public String submit_position(@ModelAttribute Position new_item) {
//		Position item=new_item;
		if (new_item.getTitle().equals("")) {
			new_item.setTitle("untitle");
		}
		rep.newPosition(new_item);
		return "redirect:/admin/position";
	}

	@GetMapping("/rmitem")
	public String rm_position(@RequestParam String id) {
		int _id_position = Integer.parseInt(id);
		rep.deletePosition(_id_position);
		return "redirect:/admin/position";
	}

	@GetMapping("/changeitem")
	public String change_position(@RequestParam String id, Model model) {
		int _id_position = Integer.parseInt(id);
		model.addAttribute("up_item", rep.findById(_id_position));
		return Views.POSITION_EDIT;
	}

	@PostMapping("/updateposition")
	public String update_position(@ModelAttribute Position up_item) {
//		Position item=new_item;
		rep.update(up_item);
		return "redirect:/admin/position";
	}

	/**
	 * 
	 * ResponseEntity<?>: ? <=> return type template data <br/>
	 * ResponseEntity &lt;Position&gt;
	 * 
	 * @code ex: ResponseEntity.ok(data) ==> ?:Position
	 * 
	 * 
	 */

	@PostMapping("/active")
	public ResponseEntity<Position> changeStatusAJax(@RequestBody Position data) {
		rep.updateStatus(data.getId(), data.getStatus());

		return ResponseEntity.ok(data);// return object-->parse json
	}
}
