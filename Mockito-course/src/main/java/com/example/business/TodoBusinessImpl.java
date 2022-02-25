package com.example.business;

import java.util.ArrayList;
import java.util.List;

import com.example.data.api.TodoService;

//TodoBusinessImpl is SUT (System under test)
//TodoService is dependency, TodoBusinessImpl depends on TodoService to run
public class TodoBusinessImpl {
    private TodoService todoService;
    private TodoService todoServiceMock;

    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
