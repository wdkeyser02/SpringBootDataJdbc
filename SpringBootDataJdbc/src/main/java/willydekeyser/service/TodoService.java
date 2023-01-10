package willydekeyser.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
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
		Todo newTodo = Todo.builder()
				.id(null)
				.title(todo.title())
				.content(todo.content())
				.publishedOn(LocalDateTime.now())
				.updatedOn(null)
				.owner(AggregateReference.to(todo.ownerId()))
				.comments(null)
				.build();
		return todoRepository.save(newTodo);
	}
	
	public List<Todo> createListTodo(List<TodoCreate> todos) {
		List<Todo> newTodos = new ArrayList<>();
		todos.forEach(todo -> {
			Todo newTodo = Todo.builder()
					.id(null)
					.title(todo.title())
					.content(todo.content())
					.publishedOn(LocalDateTime.now())
					.updatedOn(null)
					.owner(AggregateReference.to(todo.ownerId()))
					.comments(null)
					.build();
		newTodos.add(newTodo);
		});
		return todoRepository.saveAll(newTodos);
	}
	
	public Todo updateTodo(TodoUpdate todo) {
		Todo oldTodo = todoRepository.findById(todo.id()).orElse(null);
		Todo newTodo = Todo.builder()
				.id(todo.id())
				.title(todo.title())
				.content(todo.content())
				.publishedOn(oldTodo.publishedOn())
				.updatedOn(LocalDateTime.now())
				.owner(AggregateReference.to(todo.ownerId()))
				.comments(todo.comments())
				.build();
		return todoRepository.save(newTodo);
	}
	
	public Todo todoAddComment(Integer id, CommentUpdate comment) {
		Todo todo = todoRepository.findById(id).orElse(null);
		Comment newComment = Comment.builder()
				.name(comment.name())
				.content(comment.content())
				.publishedOn(LocalDateTime.now())
				.updatedOn(null)
				.build();
		todo.addComment(newComment);
		return todoRepository.save(todo);
	}
	
	public Todo todoAddListComment(Integer id, List<CommentUpdate> comments) {
		Todo todo = todoRepository.findById(id).orElse(null);
		comments.forEach(comment -> {
			Comment newComment = Comment.builder()
					.name(comment.name())
					.content(comment.content())
					.publishedOn(LocalDateTime.now())
					.updatedOn(null)
					.build();
			System.err.println(newComment);
			todo.addComment(newComment);
		});
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
