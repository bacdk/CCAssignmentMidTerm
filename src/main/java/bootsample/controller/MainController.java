package bootsample.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootsample.model.Tintuc;
import bootsample.service.TintucService;

@Controller
public class MainController {
	@Autowired
	private TintucService tintucService;
	//private TaskService taskService;

	@GetMapping("/home")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("tintucs", tintucService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/new-task")
	public String newTask(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	
	@PostMapping("/save-task")
	public String saveTask(@ModelAttribute Tintuc tintuc, BindingResult bindingResult, HttpServletRequest request){
		//tin.setDateCreated(new Date());
		tintucService.save(tintuc);
		request.setAttribute("tintucs", tintucService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	
	@GetMapping("/update-task")
	public String updateTask(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("tintuc", tintucService.findTintuc(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	
	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id, HttpServletRequest request){
		tintucService.delete(id);
		request.setAttribute("tintucs", tintucService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	//
	@GetMapping("/view-task")
	public String viewTask(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("tintuc", tintucService.findTintuc(id));
		request.setAttribute("mode", "MODE_VIEW");
		return "index";
	}
	
}
