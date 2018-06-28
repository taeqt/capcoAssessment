/**
 * @author Tae Kyoo Yang
 *
 */
package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class ListRepository extends InMemoryRepository<ToDoItem> {
	
	/*
	 * Updates a given (original) ToDoItem with new values (updated).
	 * Should only be called if a given ToDoItem with a desired id value is found. (From InMemoryRepository class)
	 */
    protected void updateIfExists(ToDoItem original, ToDoItem updated) {
        original.setName(updated.getName());
        original.setDate(updated.getDate());
    }
    
    /*
	 * Updates a given (original) ToDoItem with a new isComplete status
	 * Should only be called if a given ToDoItem with a desired id value is found. (From InMemoryRepository class)
	 */
    protected void updateCompleteStatus(ToDoItem original, boolean newStatus) {
    	original.setComplete(newStatus);
    }
    
    /*
	 * Updates a given (original) ToDoItem with a new isImportant status
	 * Should only be called if a given ToDoItem with a desired id value is found. (From InMemoryRepository class)
	 */
    protected void updateImportantStatus(ToDoItem original, boolean newStatus) {
    	original.setImportant(newStatus);
    }
    
}