package com.cloudsherpas.java.api.endpoint;

import com.cloudsherpas.java.api.resource.ToDoResource;
import com.cloudsherpas.java.service.ToDoService;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Api(name = "todo",
     scopes = {"https://www.googleapis.com/auth/userinfo.email"},
     clientIds = {"702432393067-2aej40l20jhl204fnprodfbkq2j32ef0.apps.googleusercontent.com"},
     version = "1")
public class ToDoEndpoint {

    @Autowired
    @Qualifier("toDoService")
    private ToDoService toDoService;

    @ApiMethod(name = "get",
               path = "get/{id}",
               httpMethod = ApiMethod.HttpMethod.GET)
    public ToDoResource getToDo(@Named("id") Long id) {
        return toDoService.getToDo(id);
    }

    @ApiMethod(name = "list",
               path = "list",
               httpMethod = ApiMethod.HttpMethod.GET)
    public List<ToDoResource> getAllToDos(User user) {
        return toDoService.getAllToDos(user);
    }

    @ApiMethod(name = "add",
               path = "add",
               httpMethod = ApiMethod.HttpMethod.POST)
    public void addToDo(ToDoResource toDoResource, User user) {
        toDoService.addToDo(toDoResource, user);
    }


    @ApiMethod(name = "update",
               path = "update/{id}",
               httpMethod = ApiMethod.HttpMethod.PUT)
    public void updateToDo(@Named("id") Long id,
                           ToDoResource toDoResource) throws NoSuchFieldException, IllegalAccessException {
        toDoService.updateToDo(id, toDoResource);
    }

    @ApiMethod(name = "delete",
               path = "delete",
               httpMethod = ApiMethod.HttpMethod.DELETE)
    public void deleteToDo(@Named("key") String key) {
        toDoService.deleteToDo(Long.valueOf(key));
    }
}
