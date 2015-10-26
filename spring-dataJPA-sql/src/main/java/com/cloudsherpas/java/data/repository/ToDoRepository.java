package com.cloudsherpas.java.data.repository;

import com.cloudsherpas.java.data.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    Collection<ToDo> findByOwnerEmail(String email);

}
