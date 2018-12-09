package com.pschorr.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pschorr.bean.DomainRegistrationBean;
import com.pschorr.resources.AppConfig;
import com.pschorr.resources.Factory;
import com.pschorr.resources.JSONParser;
import com.pschorr.service.DomainRegistrationService;

@Path("Domains")
public class DomainRegistrationAPI {

	@Path("RegisterDomain")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerDomain(String dataRecieved) throws Exception {
		Response response = null;
		try {
			DomainRegistrationBean bean = JSONParser.fromJson(dataRecieved,
					DomainRegistrationBean.class);
			
			DomainRegistrationService service = Factory
					.createDomainRegistrationService();
			bean = service.registerDomain(bean);
			
			String successMessage = this.getSuccessMessage(bean);
			
			bean = new DomainRegistrationBean();
			bean.setMessage(successMessage);
			
			String returnString = JSONParser.toJson(bean);
			response = Response.status(Status.OK).entity(returnString).build();
		} catch (Exception e) {
			
			String errorMessage = AppConfig.PROPERTIES.getProperty(e.getMessage());
			
			DomainRegistrationBean bean = new DomainRegistrationBean();
			bean.setMessage(errorMessage);
			
			String returnString = JSONParser.toJson(bean);

			response = Response.status(Status.SERVICE_UNAVAILABLE)
					.entity(returnString).build();
		}
		return response;
	}

	@Path("fetchDomainPlans")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchDomainPlans() throws Exception {
		String returnValue = null;
		Response response = null;
		try {
			DomainRegistrationService domainRegistrationService = Factory.createDomainRegistrationService();
			List<String> domainPlans = domainRegistrationService.getDomainPlans();
			returnValue = JSONParser.toJson(domainPlans);
			response = Response.status(Status.OK).entity(returnValue).build();
		} catch (Exception e) {
			String errorMessage = AppConfig.PROPERTIES.getProperty(e.getMessage());
			
			DomainRegistrationBean domainRegistrationBean = new DomainRegistrationBean();
			domainRegistrationBean.setMessage(errorMessage);
			
			String returnString = JSONParser.toJson(domainRegistrationBean);

			response = Response.status(Status.SERVICE_UNAVAILABLE)
					.entity(returnString).build();
		}
		return response;
	}
	
	private String getSuccessMessage(DomainRegistrationBean domainRegistrationBean){
		String message = AppConfig.PROPERTIES
				.getProperty("DOMAINREGISTERAPI.REGISTER_SUCCESS1");
		message += domainRegistrationBean.getDomainRegistrationId();
		return message;
	}

}