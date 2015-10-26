package com.cloudsherpas.java.util;

import com.cloudsherpas.java.api.resource.ToDoResource;
import com.cloudsherpas.java.data.domain.ToDo;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.util.Date;

/**
 * @author RMPader
 */
public class ResourceUtil {

    /* (non-Javadoc)
     *
     * Re-implementing this method to accept and return a different model/resource type
     * is a good way to standardize the API.
     *
     * Example:
     *      public static UserResource toResource(User user){...}
     *      public static OtherResource toResource(Other other){...}
     */
    public static ToDoResource toResource(ToDo toDo) {
        ToDoResource response = new ToDoResource();
        response.setId(toDo.getId());
        response.setName(toDo.getName());

        // The following lines are made so to avoid the trainwreck code smell.
        // It's unnecessarily verbose. I know.
        DateTime dueDate = toDo.getDueDate();
        LocalDateTime localDueDate = dueDate.toLocalDateTime();
        Date due = localDueDate.toDate();
        long dueDateMillis = due.getTime();
        response.setDueDateMillis(dueDateMillis);
        return response;
    }

}
