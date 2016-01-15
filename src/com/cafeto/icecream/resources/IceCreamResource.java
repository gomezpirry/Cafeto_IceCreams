package com.cafeto.icecream.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.cafeto.icecream.model.IceCream;
import com.cafeto.icecream.model.IceCreamService;

public class IceCreamResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	IceCreamService creamService;

	public IceCreamResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
		creamService = new IceCreamService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public IceCream getIceCream() {
		IceCream cream = creamService.getIceCream(id);
		return cream;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public IceCream getIceCreamAsHtml() {
		IceCream cream = creamService.getIceCream(id);
		return cream;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putIceCream(JAXBElement<IceCream> creamElement) {
		IceCream cream = creamElement.getValue();
		Response response;
		if (creamService.getIceCreams().containsKey(cream.getId())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		creamService.createIceCream(cream);
		return response;
	}

	@DELETE
	public void deleteIceCream() {
		creamService.deleteIceCream(id);
	}

}