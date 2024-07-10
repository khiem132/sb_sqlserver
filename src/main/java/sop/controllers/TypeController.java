package sop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}
