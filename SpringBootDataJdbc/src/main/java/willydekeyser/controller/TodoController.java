package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Todo;
import willydekeyser.repository.TodoRepository;

@RestController
@RequiredArgsConstructor
public class TodoController {

	private final TodoRepository todoRepository;
	
	@GetMapping("/todo")
	public List<Todo> getTodos() {
		return todoRepository.findAll();
	}
}
