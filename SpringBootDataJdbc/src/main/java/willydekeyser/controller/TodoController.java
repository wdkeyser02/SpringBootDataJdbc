package willydekeyser.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Todo;
import willydekeyser.model.dto.CommentUpdate;
import willydekeyser.model.dto.TodoCreate;
import willydekeyser.model.dto.TodoDetails;
import willydekeyser.model.dto.TodoUpdate;
import willydekeyser.service.TodoService;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;
	
	@GetMapping
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}
	
	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable("id") Integer id) {
		return todoService.getTodoById(id).orElse(null);
	}
	
	@GetMapping("/{id}/details")
	public TodoDetails getTodoDetails(@PathVariable("id") Integer id) {
		return todoService.getTodoDetails(id);
	}
	
	@PostMapping
	public Todo createTodo(@RequestBody TodoCreate todo) {
		return todoService.createTodo(todo);
	}
	
	@PostMapping("/all")
	public List<Todo> createListTodo(@RequestBody List<TodoCreate> todo) {
		return todoService.createListTodo(todo);
	}
	
	@PostMapping("/{id}/comment")
	public Todo todoAddComment(@PathVariable("id") Integer id, @RequestBody CommentUpdate comment) {
		return todoService.todoAddComment(id, comment);
	}
	
	@PostMapping("/{id}/comment/all")
	public Todo todoAddListComment(@PathVariable("id") Integer id, @RequestBody List<CommentUpdate> comments) {
		return todoService.todoAddListComment(id, comments);
	}
	
	@PutMapping
	public Todo updateTodo(@RequestBody TodoUpdate todo) {
		return todoService.updateTodo(todo);
	}
	
	@PatchMapping
	public Todo patchTodo(@RequestBody TodoUpdate todo) {
		return todoService.updateTodo(todo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable("id") Integer id) {
		todoService.deleteTodo(id);
	}
	
	@DeleteMapping("/all")
	public void deleteAllTodo() {
		todoService.deleteAllTodo();
	}
}
