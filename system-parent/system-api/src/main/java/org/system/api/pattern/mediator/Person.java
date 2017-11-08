package org.system.api.pattern.mediator;

/**
 * 
 * @author shinebar
 *抽象同事对象
 */
public abstract class Person {
	protected String name;
    protected Mediator mediator;
    
    Person(String name,Mediator mediator){
        this.name = name;
        this.mediator = mediator;
    }
}
