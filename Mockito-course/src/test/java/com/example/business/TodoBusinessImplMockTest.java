package com.example.business;

import static org.junit.Assert.*;
import com.example.data.api.TodoService;
import com.example.data.api.TodoServiceStub;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
//import com.example.data.stub.TodoServiceStub;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {
        TodoService todoServiceMock =  mock(TodoService.class);

        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
                "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummmy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, filteredTodos.size());
        for(String i: filteredTodos) {
            System.out.println(i);
        }
    }
}

