package fr.pe.jvi.event;

import javax.enterprise.event.Observes;

public class ObservateurEvenementHystrix
{
	public void observateurHystrix(@Observes EvenementHystrix evenementHystrix)
	{
		System.out.println("Observation d'un evenement Hystrix : " + evenementHystrix);
	}
}
