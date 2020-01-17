package org.antislashn.communes.config;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class ApplicationConfiguration extends Application {
	
	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", 
        					"org.antislashn.communes.services,org.antislashn.wait");
        return properties;
	}

}
