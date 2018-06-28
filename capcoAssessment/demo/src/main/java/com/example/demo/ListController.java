/**
 * @author Tae Kyoo Yang
 *
 */
package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.hateoas.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(ToDoItem.class)
@RequestMapping(value = "/todo", produces = "application/json")
public class ListController {
	
	//The Repository holds the list of all ToDo Items
    @Autowired
    private ListRepository repository;
    
    
    /*
     * The addItem method takes two parameters (name and string) and creates and adds a new ToDoItem with 
     * the given name and date to the repository list.
     * Returns the unique id of the item created and added.
     */
    @RequestMapping(value ="/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Long> addItem(@RequestParam String name, String date) {
    	ToDoItem itemToCreate = new ToDoItem();
    	itemToCreate.setName(name);
    	itemToCreate.setDate(date);
    	ToDoItem createdItem = repository.create(itemToCreate);
        return new ResponseEntity<>(createdItem.getId(), HttpStatus.OK);
    }
    
    /*
     * The deleteItem method takes one variable (id) and deletes the corresponding ToDo Item in the
     * repository list. Responds with OK Http status if it was found & deleted, or NOT_FOUND Http status if
     * there is no ToDo Item with the corresponding id value.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        boolean wasDeleted = repository.delete(id);
        HttpStatus responseStatus = wasDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(responseStatus);
    }
    
    /*
     * The markComplete method takes an id as a variable and a boolean value as a parameter and sets the isComplete value of
     * the ToDo Item that corresponds to the id value to the given boolean value.
     * 
     * Returns OK Httpstatus if found and status changed, returns NOT_FOUND if no ToDo Item corresponds to the given id value
     */
    @RequestMapping(value = "/markComplete/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<ToDoItem> markComplete(@PathVariable Long id, @RequestParam boolean value) {
        boolean wasUpdated = repository.markComplete(id, value);
        if (wasUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /*
     * The markImportant method takes an id as a variable and a boolean value as a parameter and sets the isImportant value of
     * the ToDo Item that corresponds to the id value to the given boolean value.
     * 
     * Returns OK Httpstatus if found and status changed, returns NOT_FOUND if no ToDo Item corresponds to the given id value
     */
    @RequestMapping(value = "/markImportant/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<ToDoItem> markImportant(@PathVariable Long id, @RequestParam boolean value) {
        boolean wasUpdated = repository.markImportant(id, value);
        if (wasUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /*
     * The update method takes two parameters (name and date) and replaces the original name and date of the
     * ToDo item that corresponds to the id value.
     * 
     * Returns OK Httpstatus if a corresponding ToDo Item is found and updated, 
     * Returns NOT_FOUND if no ToDoItem corresponds to the given id value.
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<ToDoItem> update(@PathVariable Long id, @RequestParam String name, String date) {
    	ToDoItem newItem = new ToDoItem();
    	newItem.setName(name);
    	newItem.setDate(date);
        boolean wasUpdated = repository.update(id, newItem);
        if (wasUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /*
     * The getList method returns the entire list of ToDo Items found in the repository. 
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<ToDoItem>> getList() {
        List<ToDoItem> list = repository.returnAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}