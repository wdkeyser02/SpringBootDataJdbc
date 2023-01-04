package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Owner;
import willydekeyser.model.Todo;
import willydekeyser.model.dto.TodoDetails;
import willydekeyser.repository.OwnerRepository;
import willydekeyser.repository.TodoRepository;

@RestController
@RequiredArgsConstructor
public class TodoController {

	private final TodoRepository todoRepository;
	private final OwnerRepository ownerRepository;
	
	@GetMapping("/todo")
	public List<Todo> getTodos() {
		return todoRepository.findAll();
	}
	
	@GetMapping("/todo/{id}")
	public Todo getTodoById(@PathVariable("id") Integer id) {
		return todoRepository.findById(id).get();
	}
	
	@GetMapping("/todo/{id}/details")
	public TodoDetails getTodoDetails(@PathVariable("id") Integer id) {
		Todo todo = todoRepository.findById(id).get();
		Owner owner = ownerRepository.findById(todo.owner().getId()).get();
		return new TodoDetails(todo, owner);
	}
}
