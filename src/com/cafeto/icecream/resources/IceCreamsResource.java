package com.cafeto.icecream.resources;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.cafeto.icecream.model.IceCream;
import com.cafeto.icecream.model.IceCreamService;

/** Class IceCreamsResource. 
 *  In this class are added resource maps to the path given in annotation
 */

@Path("/cream")
public class IceCreamsResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	IceCreamService creamService;

	public IceCreamsResource() {
		creamService = new IceCreamService();
	}

	/** function getIceCreams(). 
	 *  This function displays all ice cream in stock
	 */
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<IceCream> getIceCreams() {
		return creamService.getIceCreamAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<IceCream> getIceCreamsAsHtml() {
		return creamService.getIceCreamAsList();
	}
	
	/** function getIceCreams(). 
	 *  This function displays all ice cream in stock
	 */
	@GET
	@Path("sort")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<IceCream> getIceCreamsSort() {
		return creamService.getIceCreamAsSortList();
	}

	@GET
	@Path("sort")
	@Produces(MediaType.TEXT_XML)
	public List<IceCream> getIceCreamsAsSortHtml() {
		return creamService.getIceCreamAsSortList();
	}

	/** function getCount(). 
	 *  This function displays the number of ice cream that overcome a given cost.
	 *  The path to this function is ../rest/cream/cost_count/"cost minimum"
	 */
	@GET
	@Path("cost_count/{cost}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount(@PathParam("cost") int cost) {
		return String.valueOf(creamService.getIceCreamCostCount(cost));
	}
	
	/** function getIceCreamsinStock(). 
	 *  This function displays the number of ice cream that overcome a given amount.
	 *  The path to this function is ../rest/cream/stock/"amount minimum"
	 */
	@GET
	@Path("stock/{amount}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<IceCream> getIceCreamsinStock(@PathParam("amount") int amount) {
		return creamService.getIceCreamInStock(amount);
	}

	@GET
	@Path("stock/{amount}")
	@Produces(MediaType.TEXT_XML)
	public List<IceCream> getIceCreamsinStockAsHtml(@PathParam("amount") int amount) {
		return creamService.getIceCreamInStock(amount);
	}
	
	/** function createIceCream(). 
	 *  This function add a ice cream to stock
	 *  The path to this function is ../add_icecream.html
	 */
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createIceCream(@FormParam("id") String id,
			@FormParam("icecreamname") String name,
			@FormParam("icecreamamount") int amount,
			@FormParam("icecreamcost") int cost,
			@FormParam("icecreamflavor") String flavor,
			@Context HttpServletResponse servletResponse) throws IOException {
		IceCream cream = new IceCream(id, name, amount, cost, flavor);
		creamService.createIceCream(cream);
		servletResponse.sendRedirect("./cream/");
	}

	@Path("{cream}")
	public IceCreamResource getIceCream(@PathParam("cream") String id) {
		return new IceCreamResource(uriInfo, request, id);
	}
	
			
}

