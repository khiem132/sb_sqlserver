package sop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sop.models.Category;
import sop.models.Position;
import sop.models.TypeCategory;
import sop.repositories.CategoryRepository;
import sop.repositories.TypeRepository;
import sop.utils.FileUtility;
import sop.utils.Views;

@Controller
@RequestMapping("/admin/cates")
public class CategoryController {

	@Autowired
	CategoryRepository repCate;
	@Autowired
	TypeRepository repType;

	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("pathroot",System.getProperty("user.dir"));
		model.addAttribute("categories",repCate.findAll());
		return Views.CATEGORY_INDEX;
	}
	
	@GetMapping("/create")
	public String newCategory(Model model) {
		Category item = new Category();
		model.addAttribute("newItem", item);
		List<TypeCategory> lsType = repType.findAll();
		model.addAttribute("lsType", lsType);
		return Views.CATEGORY_CREATE;
	}

	@PostMapping("/newcategory")
	public String submit_position(@RequestParam("idType") int idType, @RequestParam("title") String title,
			@RequestParam("no") int no, @RequestParam("status") int status,
			@RequestParam("image") MultipartFile image) {
		Category item = new Category();
		item.setIdType(idType);
		item.setTitle(title);
		item.setNo(no);
		item.setStatus(status);
		item.setImage(FileUtility.uploadFileImage(image, "uploads"));

		repCate.newCategory(item);
		return "redirect:/admin/cates";
	}
	@GetMapping("/rmitem")
	public String rm_position(@RequestParam String id) {
		int idCate = Integer.parseInt(id);
		repCate.deleteCategory(idCate);
		return "redirect:/admin/cates";
	}
}
