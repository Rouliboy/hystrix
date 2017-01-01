package fr.pe.jvi.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import fr.pe.jvi.beans.MonBeanCDI;


public class CommandeCDI extends HystrixCommand<String> 
{
	private final MonBeanCDI beanCDI;

    public CommandeCDI(MonBeanCDI beanCDI) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup2"));
        this.beanCDI = beanCDI;
    }

    @Override
    protected String run() {
    	beanCDI.emettreEvenement();
        return "Bean CDI " + beanCDI.getValeur();
    }
}