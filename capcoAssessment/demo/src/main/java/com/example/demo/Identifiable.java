/**
 * @author Tae Kyoo Yang
 *
 */
package com.example.demo;

/*
 * This interface is mainly to mark our ToDoItems that are identifiable by an ID of any type. (Long)
 */
public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {
    public void setId(Long id);
}