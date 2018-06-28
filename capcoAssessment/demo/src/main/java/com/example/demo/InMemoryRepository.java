/**
 * @author Tae Kyoo Yang
 *
 */
package com.example.demo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;


/*
 * To be extended by our ListRepository class.
 * Defines a generic version of a repository.  Maintains a list of T items, capable of 
 * -creation
 * -deletion
 * -query by id
 * -updates
 */
public abstract class InMemoryRepository<T extends Identifiable> {

	/* 
	 * Id Generator that will assign a unique id to each item in the list.
	 */
	@Autowired
	private IdGenerator idGenerator;
	
	/* 
	 * Maintain a list of generic Items. 
	 */
	private List<T> itemList = Collections.synchronizedList(new ArrayList<>());
	
	/* 
	 * Create an element and add it to the list
	 */
	public T create(T element) {
        itemList.add(element);
        element.setId(idGenerator.getNextId());
        return element;
    }
	
	/*
	 * Delete an item from the list if an item with the corresponding id is found
	 * Returns true if found and removed, false if not.
	 */
	public boolean delete(Long id) {
        return itemList.removeIf(element -> element.getId().equals(id));
    }
	
	/*
	 * Returns the entire list of items
	 */
    public List<T> returnAll() {
        return itemList;
    }
    
    /*
     * Finds an Item by ID.
     */
    public Optional<T> findById(Long id) {
        return itemList.stream().filter(e -> e.getId().equals(id)).findFirst();
    }
    
    /*
     * Return the size of the item List
     */
    public int listSize() {
        return itemList.size();
    }
    
    /*
     * Clear the entire list.
     */
    public void clear() {
    	itemList.clear();
    }
    
    /*
     * Update an item with the corresponding id's isComplete status to the given newStatus. 
     * Return true if the id points to a valid item.
     */
    public boolean markComplete(Long id, boolean newStatus) {
    	Optional<T> element = findById(id);
        element.ifPresent(original -> updateCompleteStatus(original, newStatus));
        return element.isPresent();
    }
    
    /*
     * Update an item with the corresponding id's isImportant status to the given newStatus. 
     * Return true if the id points to a valid item.
     */
    public boolean markImportant(Long id, boolean newStatus) {
    	Optional<T> element = findById(id);
        element.ifPresent(original -> updateImportantStatus(original, newStatus));
        return element.isPresent();
    }
    
    /*
     * Update a given item referenced by a given ID. (Name and date only)
     */
    public boolean update(Long id, T updated) {
        if (updated == null) {
            return false;
        }
        else {
            Optional<T> element = findById(id);
            element.ifPresent(original -> updateIfExists(original, updated));
            return element.isPresent();
        }
    }
    
    protected abstract void updateIfExists(T original, T desired);
    
    protected abstract void updateCompleteStatus(T original, boolean newStatus);
    
    protected abstract void updateImportantStatus(T original, boolean newStatus);
}
