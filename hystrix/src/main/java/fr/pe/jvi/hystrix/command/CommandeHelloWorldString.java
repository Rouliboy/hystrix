package fr.pe.jvi.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;


public class CommandeHelloWorldString extends HystrixCommand<String> 
{
	private final String name;

    public CommandeHelloWorldString(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        return "Hello " + name + "!";
    }
}