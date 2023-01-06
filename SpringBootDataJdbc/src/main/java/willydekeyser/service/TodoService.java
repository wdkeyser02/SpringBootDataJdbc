package willydekeyser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Comment;
import willydekeyser.model.Owner;
import willydekeyser.model.Todo;
import willydekeyser.model.dto.TodoDetails;
import willydekeyser.repository.OwnerRepository;
import willydekeyser.repository.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final TodoRepository todoRepository;
	private final OwnerRepository ownerRepository;
	
	public List<Todo> getTodos() {
		return todoRepository.findAll();
	}
	
	public Optional<Todo> getTodoById(Integer id) {
		return todoRepository.findById(id);
	}
	
	public TodoDetails getTodoDetails(Integer id) {
		Todo todo = todoRepository.findById(id).get();
		Owner owner = ownerRepository.findById(todo.owner().getId()).get();
		return new TodoDetails(todo, owner);
	}
	
	public Todo createTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public List<Todo> createListTodo(List<Todo> todos) {
		return todoRepository.saveAll(todos);
	}
	
	public Todo updateTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public Todo patchTodo(Todo todo) {
		return todoRepository.save(todo);
	}
	
	public Todo todoAddComment(Integer id, Comment comment) {
		Todo todo = todoRepository.findById(id).orElse(null);
		todo.addComment(comment);
		return todoRepository.save(todo);
	}
	
	public Todo todoRemoveComment(Integer id, Comment comment) {
		Todo todo = todoRepository.findById(id).orElse(null);
		todo.removeComment(comment);
		return todoRepository.save(todo);
	}
	
	public void deleteTodo(Integer id) {
		todoRepository.deleteById(id);
	}
	
	public void deleteAllTodo() {
		todoRepository.deleteAll();
	}
}
