package com.example.Assignment.dao;


import com.example.Assignment.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, String> {

}