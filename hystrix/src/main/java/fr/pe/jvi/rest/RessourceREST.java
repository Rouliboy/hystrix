package fr.pe.jvi.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.pe.jvi.beans.MonBeanCDI;
import fr.pe.jvi.hystrix.command.CommandeCDI;
import fr.pe.jvi.hystrix.command.CommandeHelloWorldString;
import fr.pe.jvi.intercepteur.Audit;
import fr.pe.jvi.intercepteur.IntercepteurContexte;

@Path("hystrix")
public class RessourceREST
{
	@Inject
	private MonBeanCDI m_monBeanCDI;
	
	@GET
	@Path("string")
	public String appelerCommandeSimpleString()
	{
		CommandeHelloWorldString commande = new CommandeHelloWorldString("Julien");
		return commande.execute();
	}
	
	@GET
	@Path("cdi")
	public String appelerCommandeCDI()
	{
		CommandeCDI commande = new CommandeCDI(m_monBeanCDI);
		return commande.execute();
	}
	
	@GET
	@Path("sansHystrix")
	public String appelerCommandeSansHystrix()
	{
		return m_monBeanCDI.getValeur();
	}

}
