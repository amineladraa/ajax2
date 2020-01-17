package org.antislashn.communes.servlets;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.antislashn.communes.dao.CommuneDAO;

/**
 * Application Lifecycle Listener implementation class ApplicationFilter
 *
 */
@WebListener
public class ApplicationFilter implements ServletRequestListener {


    public void requestInitialized(ServletRequestEvent evt)  {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("france");
        evt.getServletContext().setAttribute("EMF", emf);
        CommuneDAO communeDAO = new CommuneDAO(emf);
        evt.getServletContext().setAttribute("COMMUNE_DAO", communeDAO);
    }
	
    public void requestDestroyed(ServletRequestEvent evt)  { 
    	EntityManagerFactory emf = (EntityManagerFactory) evt.getServletContext().getAttribute("EMF");
    	emf.close();
    } 
}
