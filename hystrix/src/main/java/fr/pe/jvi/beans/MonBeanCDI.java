package fr.pe.jvi.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import fr.pe.jvi.event.EvenementHystrix;
import fr.pe.jvi.intercepteur.Audit;

@Named
//@ApplicationScoped
public class MonBeanCDI {

	/** L'évement CDI*/
	@Inject
	private Event<EvenementHystrix> m_evenement;
	
	public String getValeur()
	{
		return this.getClass().getAnnotations()[0].toString();
	}
	
	public void emettreEvenement()
	{
		m_evenement.fire(new EvenementHystrix("MonBeanCDI", 0));
	}
}
