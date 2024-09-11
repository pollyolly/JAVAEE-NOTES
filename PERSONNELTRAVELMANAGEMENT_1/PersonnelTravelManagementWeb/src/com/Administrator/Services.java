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
import com.TravelDa.ServicesDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.ServiceProviderEntity;
import com.TravelEntity.ServicesEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class Services
 */
@WebServlet("/Services")
public class Services extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServiceProviderDa SPDa;
    private ServicesDa SDa;
    private RequestDispatcher rd;
    private StatusDa statusda;
    private ServicesEntity entity;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Services() {
        // TODO Auto-generated constructor stub
    	SPDa = new ServiceProviderDa();
    	SDa = new ServicesDa();
    	statusda = new StatusDa();
    	entity = new ServicesEntity();
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String form, company, service, description, type, classe, amount, status, ids;
		int statusid, typeid, classid, id, compid;
		double amounts;
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form){
			case "addServices":
				company = request.getParameter("company");
				service = request.getParameter("service");
				description = request.getParameter("description");
				type = request.getParameter("type");
				classe = request.getParameter("class");
				amount = request.getParameter("cost");
				status = request.getParameter("status");
				statusid = Integer.valueOf(status);
				typeid = Integer.valueOf(type);
				classid = Integer.valueOf(classe);
				amounts = Double.parseDouble(amount);
				compid = Integer.valueOf(company);
				entity.setServiceproviderid(compid);
				entity.setService(service);
				entity.setDescription(description);
				entity.setTypeid(typeid);
				entity.setClassid(classid);
				entity.setAmount(amounts);
				entity.setStatusid(statusid);
				SDa.insertServices(entity);
			break;
			case "editServices":
				company = request.getParameter("company2");
				service = request.getParameter("service2");
				description = request.getParameter("description2");
				type = request.getParameter("type2");
				classe = request.getParameter("class2");
				amount = request.getParameter("cost2");
				status = request.getParameter("status2");
				ids = request.getParameter("id");
				compid = Integer.valueOf(company);
				id = Integer.valueOf(ids);
				statusid = Integer.valueOf(status);
				typeid = Integer.valueOf(type);
				classid = Integer.valueOf(classe);
				amounts = Double.parseDouble(amount);
				entity.setServiceproviderid(compid);
				entity.setService(service);
				entity.setDescription(description);
				entity.setTypeid(typeid);
				entity.setClassid(classid);
				entity.setAmount(amounts);
				entity.setStatusid(statusid);
				entity.setId(id);
				SDa.updateServices(entity);
			break;
			case "editForm":
				SDa = new ServicesDa();
				ArrayList<ServicesEntity> svlist;
				int myid = Integer.valueOf(request.getParameter("svid"));
				svlist = SDa.getServicesById(myid);
				String jsons = new Gson().toJson(svlist);
				if (jsons.trim().length() > 0) {
					out.print(jsons);
					out.flush();
					out.close();
				} else {
					System.out.print("Services empty jsons");
				}
			break;
		}
		doGet(request, response);
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StatusEntity> statuslist;
		ArrayList<ServiceProviderEntity> splist;
		ArrayList<ServicesEntity> svlist, svtype, svclass;
		splist = SPDa.getServiceProviderList();
		svtype = SDa.getServicesType();
		svclass = SDa.getServicesClass();
		svlist = SDa.getServicesList();
		statuslist =  statusda.getStatus();
		request.setAttribute("statuslist", statuslist);
		request.setAttribute("splist", splist);
		request.setAttribute("svtype", svtype);
		request.setAttribute("svclass", svclass);
		request.setAttribute("svlist", svlist);
		rd = request.getRequestDispatcher("S-Services.jsp");
		rd.include(request, response);
	}
}
