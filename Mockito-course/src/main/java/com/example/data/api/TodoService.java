package com.example.data.api;

import java.util.List;

// External Service - Lets say this comes from WunderList(website)
public interface TodoService {
    public List<String> retrieveTodos(String user);
}