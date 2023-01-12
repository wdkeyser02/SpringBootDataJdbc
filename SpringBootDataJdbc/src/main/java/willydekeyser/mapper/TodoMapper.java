package willydekeyser.mapper;

import java.time.LocalDateTime;

import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Component;

import willydekeyser.model.Todo;
import willydekeyser.model.dto.TodoCreate;
import willydekeyser.model.dto.TodoUpdate;

@Component
public class TodoMapper {
		
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
	
	public Todo todoUpdate(Todo oldTodo, TodoUpdate todo) {
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
