package willydekeyser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import willydekeyser.mapper.CommentMapper;
import willydekeyser.mapper.TodoMapper;
import willydekeyser.model.Comment;
import willydekeyser.model.Owner;
import willydekeyser.model.Todo;
import willydekeyser.model.dto.CommentUpdate;
import willydekeyser.model.dto.TodoCreate;
import willydekeyser.model.dto.TodoDetails;
import willydekeyser.model.dto.TodoUpdate;
import willydekeyser.repository.OwnerRepository;
import willydekeyser.repository.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final TodoRepository todoRepository;
	private final OwnerRepository ownerRepository;
	private final TodoMapper todoMapper;
	private final CommentMapper commentMapper;
	
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
	
	public Todo createTodo(TodoCreate todo) {
		return todoRepository.save(todoMapper.todoCreate(todo));
	}
	
	public List<Todo> createListTodo(List<TodoCreate> todos) {
		List<Todo> newTodos = new ArrayList<>();
		todos.forEach(todo -> newTodos.add(todoMapper.todoCreate(todo)));
		return todoRepository.saveAll(newTodos);
	}
	
	public Todo updateTodo(TodoUpdate todo) {
		Todo oldTodo = todoRepository.findById(todo.id()).orElse(null);
		return todoRepository.save(todoMapper.todoUpdate(oldTodo, todo));
	}
	
	public Todo todoAddComment(Integer id, CommentUpdate comment) {
		Todo todo = todoRepository.findById(id).orElse(null);
		todo.addComment(commentMapper.CommentUpdate(comment));
		return todoRepository.save(todo);
	}
	
	public Todo todoAddListComment(Integer id, List<CommentUpdate> comments) {
		Todo todo = todoRepository.findById(id).orElse(null);
		comments.forEach(comment -> todo.addComment(commentMapper.CommentUpdate(comment)));
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
