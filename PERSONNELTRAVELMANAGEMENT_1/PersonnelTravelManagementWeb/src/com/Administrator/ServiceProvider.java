package com.Administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.ServiceProviderDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.PositionEntity;
import com.TravelEntity.ServiceProviderEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServiceProvider
 */
@WebServlet("/ServiceProvider")
public class ServiceProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceProviderDa Da;
	private StatusDa statusda;
	private ServiceProviderEntity entity;
	private RequestDispatcher rd;
	private ArrayList<ServiceProviderEntity> splist, splistbyid;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceProvider() {
        // TODO Auto-generated constructor stub
    	Da = new ServiceProviderDa();
    	statusda = new StatusDa();
    	entity = new ServiceProviderEntity();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String form = request.getParameter("forms");
		switch(form){
			case "addSP":
				String comp = request.getParameter("company");
				String cont = request.getParameter("contact");
				String web = request.getParameter("website");
				String eml = request.getParameter("email");
				String addr = request.getParameter("address");
				String stat = request.getParameter("status");
				entity.setCompany(comp);
				entity.setContact(cont);
				entity.setWebsite(web);
				entity.setEmail(eml);
				entity.setAddress(addr);
				entity.setStatusid(Integer.valueOf(stat));
				Da.insertServiceProvider(entity);
				response.sendRedirect("Redirect?servletpage=ServiceProvider");
			break;
			case "updateSP":
				String id = request.getParameter("id");
				String comp2 = request.getParameter("company2");
				String cont2 = request.getParameter("contact2");
				String web2 = request.getParameter("website2");
				String eml2 = request.getParameter("email2");
				String addr2 = request.getParameter("address2");
				String stat2 = request.getParameter("status2");
				entity.setCompany(comp2);
				entity.setContact(cont2);
				entity.setWebsite(web2);
				entity.setEmail(eml2);
				entity.setAddress(addr2);
				entity.setStatusid(Integer.valueOf(stat2));
				entity.setId(Integer.valueOf(id));
				Da.updateServiceProvider(entity);
				response.sendRedirect("Redirect?servletpage=ServiceProvider");
			break;
			case "editForm":
				Da = new ServiceProviderDa();
				ArrayList<ServiceProviderEntity> splist;
				int myid = Integer.valueOf(request.getParameter("spid"));
				splist = Da.getServiceProviderById(myid);
				String jsons = new Gson().toJson(splist);
				if (jsons.trim().length() > 0) {
					out.print(jsons);
					out.flush();
					out.close();
				} else {
					System.out.print("Positionbyid empty jsonss");
				}
			break;
		}
		list(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StatusEntity> statuslist =  statusda.getStatus();
		splist = Da.getServiceProvider();
			request.setAttribute("statuslist", statuslist);
			request.setAttribute("splist", splist);
			rd = request.getRequestDispatcher("S-Serviceprovider.jsp");
			rd.include(request, response);
	}

}
