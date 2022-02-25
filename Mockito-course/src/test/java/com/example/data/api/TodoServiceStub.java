package com.example.data.api;
//Stub is only used for Unit Testing
//we create stub in src/test/java

import java.util.Arrays;
import java.util.List;

import com.example.data.api.TodoService;

public class TodoServiceStub implements TodoService {
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
    }
}
