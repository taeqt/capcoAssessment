/**
 * @author Tae Kyoo Yang
 *
 */
package com.example.demo;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/*
 * Our IdGenerator class should maintain an AtomicLong that will be assigned to newly created ToDoItems.
 */
@Component
@Scope(org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {
    private AtomicLong nextId = new AtomicLong(1);
    public long getNextId() {
        return nextId.getAndIncrement();
    }
}