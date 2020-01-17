package org.antislashn.communes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.antislashn.communes.entities.Commune;;

public class CommuneDAO  {
	private EntityManagerFactory emf;
	
	public CommuneDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public List<Commune> getCommunesByCodePostal(String cp){
		EntityManager em = emf.createEntityManager();
		List<Commune> communes = em.createNamedQuery("Commune.getCommunesByCodePostal",Commune.class)
									.setParameter("cp", cp+"%")
									.getResultList();
		em.close();
		return communes;
	}
	
	public List<Commune> getCommunesByDebutNom(String nom){
		EntityManager em = emf.createEntityManager();
		List<Commune> communes = em.createNamedQuery("Commune.getCommunesByDebutNom",Commune.class)
									.setParameter("nom", nom+"%")
									.getResultList();
		em.close();
		return communes;
	}
	
	public Commune getCommuneById(long id) {
		EntityManager em = emf.createEntityManager();
		Commune c = em.find(Commune.class, id);
		em.close();
		return c;
	}
}
