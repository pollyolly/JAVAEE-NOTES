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

import com.google.gson.Gson;
import com.HelperClasses.Helper;
import com.TravelDa.CompanyPolicyDa;
import com.TravelDa.ServiceProviderDa;
import com.TravelDa.ServicesDa;
import com.TravelDa.TravelPlanDa;
import com.TravelEntity.CompanyPolicyEntity;
import com.TravelEntity.ServiceProviderEntity;
import com.TravelEntity.ServicesEntity;
import com.TravelEntity.TravelOrderEntity;
import com.TravelEntity.TravelPlanEntity;
import com.TravelEntity.TravelPlanListEntity;


/**
 * Servlet implementation class TravelPlanList
 */
@WebServlet("/TravelPlanList")
public class TravelPlanList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private RequestDispatcher rd;
	 private String form;
	 private String tno="";
	 private TravelPlanDa Da;
	 private ServiceProviderDa SPDa;
	 private ServicesDa SDa;
	 private TravelPlanListEntity entity, entity1;
	 private Helper helper;
	 private CompanyPolicyDa DaPolicy;
	 private String planid="";
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlanList() {
        // TODO Auto-generated constructor stub
    	Da = new TravelPlanDa();
    	SPDa = new ServiceProviderDa();
    	SDa = new ServicesDa();
    	entity = new TravelPlanListEntity();
    	entity1 = new TravelPlanListEntity();
    	helper = new Helper();
    	DaPolicy = new CompanyPolicyDa();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String pcn="", serviceprovider="", service="", type="",from="", to="", pickup="", dropoff=""
			, file="", checkin="", checkout="", departure="", returns="", stop=""
			,vendor="", description="", amount=""; 
		int stopover = 0;
		form = request.getParameter("forms");
		//tno = request.getParameter("tno");
		//planid = request.getParameter("tpid");
		//int tpid = Integer.valueOf(planid);
	switch(form){
		case "car":
			pcn = request.getParameter("pcn");
			tno = request.getParameter("tno");
			planid = request.getParameter("tpid");
			serviceprovider = request.getParameter("serviceprovider");
			service = request.getParameter("service");
			type = request.getParameter("type");
			from = request.getParameter("from");
			to = request.getParameter("to");
			pickup = request.getParameter("pickup");
			dropoff = request.getParameter("dropoff");
			entity.setPcn(pcn);
			entity.setTono(tno);
			entity.setPlanid(planid);
			entity.setServiceproviderid(Integer.valueOf(serviceprovider));
			entity.setServiceid(Integer.valueOf(service));
			entity.setTypeid(Integer.valueOf(type));
			Da.insertTravelPlanList(entity);
			entity1.setCfrom(from);
			entity1.setCto(to);
			entity1.setPickup(pickup);
			entity1.setDropoff(dropoff);
			Da.insertTravelCar(entity1);
			response.sendRedirect("Redirect?servletpage=TravelPlanList&tnos="+tno+"&tpid="+planid);
			break;
		case "hotel":
			pcn = request.getParameter("pcn");
			tno = request.getParameter("tno");
			planid = request.getParameter("tpid");
			serviceprovider = request.getParameter("serviceprovider");
			service = request.getParameter("service");
			type = request.getParameter("type");
			checkin = request.getParameter("checkin");
			checkout = request.getParameter("checkout");
			entity.setPcn(pcn);
			entity.setTono(tno);
			entity.setPlanid(planid);
			entity.setServiceproviderid(Integer.valueOf(serviceprovider));
			entity.setServiceid(Integer.valueOf(service));
			entity.setTypeid(Integer.valueOf(type));
			Da.insertTravelPlanList(entity);
			entity1.setCheckin(checkin);
			entity1.setCheckout(checkout);
			Da.insertTravelHotel(entity1);
			response.sendRedirect("Redirect?servletpage=TravelPlanList&tnos="+tno+"&tpid="+planid);
			break;
		case "flight":
			pcn = request.getParameter("pcn");
			tno = request.getParameter("tno");
			planid = request.getParameter("tpid");
			serviceprovider = request.getParameter("serviceprovider");
			service = request.getParameter("service");
			type = request.getParameter("type");
			departure = request.getParameter("departure");
			returns = request.getParameter("returns");
			stop = request.getParameter("stopover");
			if(stop != null){
			stopover = Integer.valueOf(stop);}
			from = request.getParameter("from");
			to = request.getParameter("to");
			entity.setPcn(pcn);
			entity.setTono(tno);
			entity.setPlanid(planid);
			entity.setServiceproviderid(Integer.valueOf(serviceprovider));
			entity.setServiceid(Integer.valueOf(service));
			entity.setTypeid(Integer.valueOf(type));
			Da.insertTravelPlanList(entity);
			entity1.setDeparture(departure);
			entity1.setReturns(returns);
			entity1.setStopover(stopover);
			entity1.setFfrom(from);
			entity1.setFto(to);
			Da.insertTravelFlight(entity1);
			response.sendRedirect("Redirect?servletpage=TravelPlanList&tnos="+tno+"&tpid="+planid);
			break;
		case "miscellaneous":
			pcn = request.getParameter("pcn");
			tno = request.getParameter("tno");
			planid = request.getParameter("tpid");
			type = request.getParameter("type");
			vendor = request.getParameter("vendor");
			description = request.getParameter("description");
			amount = request.getParameter("amount");
			entity.setPcn(pcn);
			entity.setTono(tno);
			entity.setPlanid(planid);
			entity.setTypeid(Integer.valueOf(type));
			Da.insertTravelPlanList(entity);
			entity1.setVendor(vendor);
			entity1.setDescription(description);
			entity1.setAmount(Double.parseDouble(amount));
			Da.insertTravelMisc(entity1);
			response.sendRedirect("Redirect?servletpage=TravelPlanList&tnos="+tno+"&tpid="+planid);
			break;
		case "popuServices":
			SDa = new ServicesDa();
			ArrayList<ServicesEntity> slist;
			String spid = "";
			spid = request.getParameter("ids");
			int id = helper.toInt(spid);
			slist = SDa.getServices(id);
			String jsons = new Gson().toJson(slist);
			if (jsons.trim().length()> 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			} else {
				System.out.print("Services List empty jsonss");
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
		int tpid = 0;
		ArrayList<TravelPlanEntity> travelplanbytono=null;
		ArrayList<TravelPlanListEntity> travelplanlist;
		ArrayList<ServiceProviderEntity> splist;
		ArrayList<CompanyPolicyEntity> policylist = null;
		policylist = DaPolicy.getPolicy();
		splist = SPDa.getServiceProviderList();
		planid = request.getParameter("tpid");
		//tpid = Integer.valueOf(planid);
		tno = request.getParameter("tno");	
		travelplanbytono = Da.getTravelPlan(tno, planid);
		travelplanlist = Da.getTravelPlanListByToNo(tno, planid);
		String names="";
		for(int i=0; travelplanbytono.size() > i; i++){
			TravelPlanEntity data = travelplanbytono.get(i);
			names += data.getName()+", ";
		}
		request.setAttribute("policylist", policylist);
		request.setAttribute("names", names);
		request.setAttribute("plan", travelplanbytono);
		request.setAttribute("planlist", travelplanlist);
		request.setAttribute("splist", splist);	
		rd = request.getRequestDispatcher("T-Travelplanlist.jsp");
		rd.include(request, response);
	}

}
