package com.dev.kevin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.kevin.model.Task;
import com.dev.kevin.model.User;
import com.dev.kevin.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private UserService userService;
	@Autowired
	private TaskRepository taskRepository;
	
	
	public Task findById(Long id) {
		Optional<Task> task = this.taskRepository.findById(id);
		return task.orElseThrow(() -> new RuntimeException
				("Tarefa Não encontrada! id:" + id + ", Tipo " + Task.class.getName()));
	}
	
	public List<Task> findAllByUserId(Long userId){
		List<Task> tasks = this.taskRepository.findByUser_Id(userId);
		return tasks;
	}
	
	@Transactional
	public Task create(Task obj) {
		User user = this.userService.findById(obj.getUser().getId());
		obj.setId(null);
		obj.setUser(user);
		obj = this.taskRepository.save(obj);
		return obj;	
	}
	
	@Transactional
	public Task update(Task obj) {
		Task newObj = findById(obj.getId());
		newObj.setDescricao(obj.getDescricao());
		return this.taskRepository.save(newObj);
	}
	
	public void delete(Long id) {
		findById(id);
		try {
			this.taskRepository.deleteById(id);
		} catch (Exception e) {
			throw new RuntimeException
				("Não é possivel deletar pois há entidades relacionadas!");
		}
		
	}
}
