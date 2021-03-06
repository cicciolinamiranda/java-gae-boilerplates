package com.cloudsherpas.java.service;

import com.cloudsherpas.java.api.resource.ToDoResource;
import com.cloudsherpas.java.data.domain.ToDo;
import com.cloudsherpas.java.data.repository.ToDoRepository;
import com.google.api.server.spi.auth.common.User;
import com.google.inject.Inject;
import org.joda.time.LocalDateTime;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static com.cloudsherpas.java.util.ResourceUtil.toResource;

@Singleton
public class ToDoService {

    @Inject
    private ToDoRepository toDoRepo;

    public ToDoResource getToDo(Long key) {
        ToDo toDo = toDoRepo.findOne(key);
        return toResource(toDo);
    }

    public List<ToDoResource> getAllToDos(User user) {
        Collection<ToDo> toDoList = toDoRepo.findByOwnerEmail(user.getEmail());

        //if only GAE supported Java 8
        List<ToDoResource> toDoResourceList = new ArrayList<>();
        for (ToDo toDo : toDoList) {
            toDoResourceList.add(toResource(toDo));
        }

        return toDoResourceList;
    }

    public void addToDo(ToDoResource toDoResource, User user) {
        LocalDateTime dueDate = LocalDateTime.fromDateFields(new Date(toDoResource.getDueDateMillis()));
        ToDo toDo = new ToDo(user.getEmail(), toDoResource.getName(), dueDate.toDateTime());
        toDoRepo.save(toDo);
    }

    public void updateToDo(Long key, ToDoResource toDoResource) throws NoSuchFieldException, IllegalAccessException {
        ToDo toDo = toDoRepo.findOne(key);
        toDo.setName(toDoResource.getName());
        toDoResource.setDueDateMillis(toDoResource.getDueDateMillis());
        toDoRepo.save(toDo);
    }

    public void deleteToDo(Long key) {
        toDoRepo.delete(key);
    }
}
