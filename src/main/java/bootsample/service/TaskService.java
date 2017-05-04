package bootsample.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

//import antlr.collections.List;
import bootsample.dao.TaskRepository;
import bootsample.model.Task;

@Service
@Transactional
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	//
	public java.util.List<Task> findAll(){
		java.util.List<Task> tasks = new ArrayList<>();
		for(Task task : taskRepository.findAll()){
			//tasks.add(task);
			tasks.add(task);
		}
		return tasks;		
	}
	//
	public Task findTask(int id){
		return taskRepository.findOne(id);
	}
	
	public void save(Task task){
		taskRepository.save(task);
	}
	
	public void delete(int id){
		taskRepository.delete(id);
	}
}
