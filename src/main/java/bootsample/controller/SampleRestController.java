package bootsample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import bootsample.service.TintucService;

@RestController
public class SampleRestController {
	//
	@Autowired
	private TintucService tintucService;
	//private TaskService taskService;
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello, World!!!";
	}
//	//
	@GetMapping("/allTask")
	public String allTintuc(){
		return tintucService.findAll().toString();
	}
	//
//	@GetMapping("/save-task")
//	public String saveTask(@RequestParam String name, @RequestParam String desc){
//		Task task = new Task(name, desc, new Date(), false);
//		taskService.save(task);
//		return "Task saved!";
//	}
//	
//	@GetMapping("/delete-task")
//	public String saveTask(@RequestParam int id){
//		taskService.delete(id);
//		return "Task deleted!";
//	}
}
