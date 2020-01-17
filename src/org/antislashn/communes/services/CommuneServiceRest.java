package org.antislashn.communes.services;


import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.antislashn.communes.dao.CommuneDAO;
import org.antislashn.communes.entities.Commune;

@Path("/communes")
public class CommuneServiceRest{
	private static String CHARSET = "charset=UTF-8";
	
	// Ne fonctionne pas sous Tomcat
	//@Resource private ServletContext servletContext;
	
	private CommuneDAO dao;
	
    @Context
    public void setServletContext(ServletContext context) {
        dao = (CommuneDAO) context.getAttribute("COMMUNE_DAO");
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cp/{cp}")
	public List<Commune> getCommunesByCodePostal(@PathParam("cp") String cp){
		//Response.status(Response.Status.OK).header(HttpHeaders.CONTENT_TYPE,CHARSET).build();
		return dao.getCommunesByCodePostal(cp);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/nom/{nom}")
	public List<Commune> getCommunesByDebutNom(@PathParam("nom") String nom){
		//Response.status(Response.Status.OK).header(HttpHeaders.CONTENT_TYPE,CHARSET).build();
		return dao.getCommunesByDebutNom(nom);
	}	


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
	public Commune getCommuneById(@PathParam("id") long id) {
		//Response.status(Response.Status.OK).header(HttpHeaders.CONTENT_TYPE,CHARSET).build();
		return dao.getCommuneById(id);
	}
}
