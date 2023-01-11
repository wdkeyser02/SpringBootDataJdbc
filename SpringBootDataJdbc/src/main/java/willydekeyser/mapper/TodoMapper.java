package willydekeyser.mapper;

import java.time.LocalDateTime;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import willydekeyser.model.Todo;
import willydekeyser.model.dto.TodoCreate;
import willydekeyser.model.dto.TodoUpdate;
import willydekeyser.repository.TodoRepository;

@RequiredArgsConstructor
@Component
public class TodoMapper {
	
	private final TodoRepository todoRepository;
	
	public Todo todoCreate(TodoCreate todo) {
		return Todo.builder()
				.id(null)
				.title(todo.title())
				.content(todo.content())
				.publishedOn(LocalDateTime.now())
				.updatedOn(null)
				.owner(AggregateReference.to(todo.ownerId()))
				.comments(null)
				.build();
	}
	
	public Todo todoUpdate(TodoUpdate todo) {
		Todo oldTodo = todoRepository.findById(todo.id()).orElse(null);
		return Todo.builder()
				.id(todo.id())
				.title(todo.title())
				.content(todo.content())
				.publishedOn(oldTodo.publishedOn())
				.updatedOn(LocalDateTime.now())
				.owner(AggregateReference.to(todo.ownerId()))
				.comments(todo.comments())
				.build();
	}

}
