/**
 * @author Tae Kyoo Yang
 *
 */
package com.example.demo;

public class ToDoItem implements Identifiable {
	
	//auto-generated unique ID
	private Long id;
	
	//Name of To Do Item
    private String name;
    
    //Date of To Do Item
    private String date;
    
    //Boolean to check if item is complete
    private boolean isComplete;
    
    //Boolean to check if item is important
    private boolean isImportant;
    
    
    /*
     * Overriden from the Identifiable interface. (From org.springframework.hateoas.Identifiable)
     */
    @Override
    public Long getId() {
        return id;
    }
    
    /*
     * Overriden from the Identifiable interface. (From org.springframework.hateoas.Identifiable)
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    /*
     * Returns name of the ToDoItem
     */
    public String getName() {
        return name;
    }
    
    /*
     * Sets the name of the ToDo Item to the given new name.
     */
    public void setName(String newName) {
        this.name = newName;
    }
    
    /*
     * Sets the date of the ToDo Item to the given new date.
     */
    public void setDate(String newDate) {
        this.date = newDate;
    }
    
    /*
     * Returns date of the ToDoItem
     */
    public String getDate() {
        return date;
    }
    
    /*
     * Sets the complete status of the ToDo Item to the given new status.
     */
    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    
    /*
     * Returns complete status of the ToDoItem
     */
    public boolean isComplete() {
        return isComplete;
    }
    
    /*
     * Sets the important status of the ToDo Item to the given new status.
     */
    public void setImportant(boolean isImportant) {
    	this.isImportant = isImportant;
    }
    
    /*
     * Returns important status of the ToDoItem
     */
    public boolean isImportant() {
    	return isImportant;
    }
    
}
