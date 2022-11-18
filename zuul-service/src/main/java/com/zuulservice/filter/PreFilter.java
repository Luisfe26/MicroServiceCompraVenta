package com.zuulservice.filter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


public class PreFilter extends ZuulFilter{

	
	private static Logger LOGGER = LoggerFactory.getLogger(PreFilter.class);
	public PreFilter() {}

	@Override
	public Object run() {		
		 RequestContext ctx = RequestContext.getCurrentContext();	    
	     StringBuffer strLog=new StringBuffer();
	     strLog.append("\n------ FILTRANDO ACCESO A PRIVADO ------\n");	    
	     
	     try {	    	
    		 String url=UriComponentsBuilder.fromHttpUrl("http://localhost:8090/").path("/person").build().toUriString();
    		 String usuario=ctx.getRequest().getHeader("usuario")==null?"":ctx.getRequest().getHeader("usuario");
    	     
    		 if (!usuario.equals(""))
    	     {
    	    	if (!usuario.equals("user"))
    	    	{
	    	    	String msgError="Usuario invalidos";
	    	    	strLog.append("\n"+msgError+"\n");	  
	    	    	ctx.setResponseBody(msgError);
	    	    	ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
	    	    	ctx.setSendZuulResponse(false); 
	    	    	LOGGER.info(strLog.toString());	    	    	
	    	    	return null;
    	    	}
    	    	ctx.setRouteHost(new URL(url));
    	     }	    	     	    	
		} catch ( IOException e) {

			e.printStackTrace();
		}
	    
	     LOGGER.info(strLog.toString());
	     return null;
	}

	
	@Override
	public boolean shouldFilter() {				
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1; 
	}

	@Override
	public String filterType() {
		return "pre";
	}


}
