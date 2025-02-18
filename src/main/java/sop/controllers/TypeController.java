package sop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sop.models.TypeCategory;
import sop.modelviews.PageView;
import sop.repositories.TypeRepository;
import sop.utils.Views;

@Controller
@RequestMapping("admin/types")
public class TypeController {
	@Autowired
	TypeRepository rep;
	@GetMapping("")
	public String index(Model model,@RequestParam(name = "cp", required = false, defaultValue = "1") int cp) {
		PageView pv = new PageView();
		pv.setPage_current(cp);
		pv.setPage_size(50);
		model.addAttribute("types", rep.findAllPaging(pv));
		model.addAttribute("pv", pv);
		return Views.TYPE_INDEX;
	}
	@GetMapping("/create")
	public String input_type(Model model) {
		TypeCategory p = new TypeCategory();
		p.setTitle("");		
		model.addAttribute("new_item", p);
		return Views.TYPE_CREATE;
	}
	@PostMapping("/newtype")
	public String submit_type(@ModelAttribute TypeCategory new_item) {
//		Position item=new_item;
		if (new_item.getTitle().equals("")) {
			new_item.setTitle("untitle");
		}
		rep.newType(new_item);
		return "redirect:/admin/types";
	}
	@GetMapping("/rmitem")
	public String rm_type(@RequestParam String id) {
		int _id_type = Integer.parseInt(id);
		rep.deleteType(_id_type);
		return "redirect:/admin/types";
	}
	@GetMapping("/changeitem")
	public String change_position(@RequestParam String id, Model model) {
		int _id_position = Integer.parseInt(id);
		model.addAttribute("up_item", rep.findById(_id_position));
		return Views.TYPE_EDIT;
	}
	@PostMapping("/update")
	public String update_type(@ModelAttribute TypeCategory up_item) {
//		Position item=new_item;
		rep.update(up_item);
		return "redirect:/admin/types";
	}
}
