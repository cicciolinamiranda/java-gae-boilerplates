package com.cloudsherpas.java.data.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "todo")
@Entity
public class ToDo {

    @Id
    @GenericGenerator(name = "gen",
                      strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "id",
            unique = true)
    private Long id;

    @Column(name = "owner_email")
    private String ownerEmail;

    @Column(name = "name")
    private String name;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "due_date")
    private DateTime dueDate;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date_created")
    private DateTime dateCreated;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date_modified")
    private DateTime dateModified;

    /* (non-Javadoc)
     *
     * Needed by ORM for class creation by reflection.
     */
    private ToDo() {
    }

    public ToDo(String ownerEmail, String name, DateTime dueDate) {
        this.ownerEmail = ownerEmail;
        this.name = name;
        this.dueDate = dueDate;
    }

    @PrePersist
    public void onSave() {
        if (this.dateCreated == null) {
            this.dateCreated = DateTime.now();
        }
        this.dateModified = DateTime.now();
    }

    /* (non-Javadoc)
     *
     * Never create a setter for the ID. If it's not automatically generated,
     * it should be set in the constructor.
     */
    public Long getId() {
        return id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(DateTime dueDate) {
        this.dueDate = dueDate;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
        return dateModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ToDo toDo = (ToDo) o;
        return Objects.equals(getId(), toDo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
