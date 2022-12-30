package willydekeyser.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;

@Table("Owner")
@Builder
public record Owner(
		@Id Integer id,
        String fullName,
        String email,
        String username,
        Address address,
        Set<Todo> todos) {

	public void addTodo(Todo todo) {
		this.todos.add(todo);
	}
	
	public void removeTodo(Todo todo) {
		this.todos.remove(todo);
	}
	
}
