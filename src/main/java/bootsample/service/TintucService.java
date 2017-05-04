package bootsample.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

//import bootsample.dao.TaskRepository;
import bootsample.dao.TintucRepository;
//import bootsample.model.Task;
import bootsample.model.Tintuc;

@Service
@Transactional
public class TintucService {
	private final TintucRepository tintucRepository;

	public TintucService(TintucRepository tintucRepository) {
		this.tintucRepository = tintucRepository;
	}
	//
	public java.util.List<Tintuc> findAll(){
		java.util.List<Tintuc> tintucs = new ArrayList<>();
		for(Tintuc tintuc : tintucRepository.findAll()){
			//tasks.add(task);
			tintucs.add(tintuc);
		}
		return tintucs;		
	}
	//
	public Tintuc findTintuc(int id){
		return tintucRepository.findOne(id);
	}
	
	public void save(Tintuc tintuc){
		tintucRepository.save(tintuc);
	}
	
	public void delete(int id){
		tintucRepository.delete(id);
	}
	
	public void viewTintuc(int id){
		tintucRepository.toString();
	}

}
