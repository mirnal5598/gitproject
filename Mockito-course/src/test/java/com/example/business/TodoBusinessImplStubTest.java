package com.example.business;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.List;

import com.example.data.api.TodoServiceStub;
import org.junit.Test;

import com.example.data.api.TodoService;
//import com.example.data.stub.TodoServiceStub;

    public class TodoBusinessImplStubTest {

        @Test
        public void testRetrieveTodosRelatedToSpring_usingAStub() {
            TodoService todoService = new TodoServiceStub();
            TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
            List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
            assertEquals(2, filteredTodos.size());
            for(String i: filteredTodos) {
                System.out.println(i);
            }
        }
    }

