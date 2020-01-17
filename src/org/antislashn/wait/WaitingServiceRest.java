package org.antislashn.wait;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/wait")
public class WaitingServiceRest {
	public static final Logger LOG = Logger.getAnonymousLogger(WaitingServiceRest.class.getName());


	@GET
	@Path("/delay/{delay}")
	@Produces(MediaType.TEXT_PLAIN)
	public String attente(@PathParam("delay") int delay) {
		LOG.info(">>> délai en secondes : "+delay);
		try {
			Thread.sleep(delay * 1_000);
		} catch (InterruptedException e) {
			return "KO";
		}
		return "OK";
	}
}
