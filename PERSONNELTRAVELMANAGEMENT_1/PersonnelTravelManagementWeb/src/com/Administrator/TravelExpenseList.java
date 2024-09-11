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

import com.TravelDa.CompanyPolicyDa;
import com.TravelDa.CurrencyDa;
import com.TravelDa.TravelExpenseDa;
import com.TravelDa.TravelPlanDa;
import com.TravelEntity.CompanyPolicyEntity;
import com.TravelEntity.CurrencyEntity;
import com.TravelEntity.TravelExpenseEntity;
import com.TravelEntity.TravelExpenseListEntity;

/**
 * Servlet implementation class TraveExpenseList
 */
@WebServlet("/TravelExpenseList")
public class TravelExpenseList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private String form, odid;
	private TravelExpenseDa Da;
	private CompanyPolicyDa DaPolicy;
	private TravelExpenseListEntity entity;
	private CurrencyDa DaCurrency;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelExpenseList() {
        // TODO Auto-generated constructor stub
    	entity = new TravelExpenseListEntity();
    	Da = new TravelExpenseDa();
    	DaPolicy = new CompanyPolicyDa();
    	DaCurrency = new CurrencyDa();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderdid="", type="", date="", reimb="", bill="", amount="",
			   vendor="", from="", to="", pickup="", dropoff="",
			   checkin="", checkout="",
			   departure="", returns="", stop="",
			   distance="",
			   description="", reason="", pcn="";
		int reimburse = 0, billable = 0, stopover=0, typeid=0;
		form = null;
		form = request.getParameter("forms");
		odid = request.getParameter("odid");
		switch(form){
		case "car":
			pcn = request.getParameter("pcn");
			odid = request.getParameter("odid");
			type = request.getParameter("type");
			if(type != null){
				typeid = Integer.valueOf(type);
			}
			date = request.getParameter("date");
			vendor = request.getParameter("vendor");
			reimb = request.getParameter("reimb");
			if(reimb != null){
				reimburse = Integer.valueOf(reimb);}
				bill = request.getParameter("billable");
			if(bill != null){
				billable = Integer.valueOf(bill);}
			amount = request.getParameter("amount");
			reason = request.getParameter("reason");
			entity.setPcn(pcn);
			entity.setId(Integer.valueOf(odid));
			entity.setTypeid(typeid);
			entity.setDate(date);
			entity.setVendor(vendor);
			entity.setTypeid(Integer.valueOf(type));
			entity.setReimburse(reimburse);
			entity.setBillable(billable);
			entity.setAmount(Double.parseDouble(amount));
			entity.setReason(reason);
			Da.insertTravelExpenseList(entity);
			from = request.getParameter("from");
			to = request.getParameter("to");
			pickup = request.getParameter("pickup");
			dropoff = request.getParameter("dropoff");
			entity.setCfrom(from);
			entity.setCto(to);
			entity.setPickup(pickup);
			entity.setDropoff(dropoff);
			Da.insertTravelExpenseListCar(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpenseList&odid="+odid);
			break;
		case "hotel":
			pcn = request.getParameter("pcn");
			odid = request.getParameter("odid");
			type = request.getParameter("type");
			if(type != null){
				typeid = Integer.valueOf(type);
			}
			date = request.getParameter("date");
			vendor = request.getParameter("vendor");
			reimb = request.getParameter("reimb");
			if(reimb != null){
				reimburse = Integer.valueOf(reimb);}
				bill = request.getParameter("billable");
			if(bill != null){
				billable = Integer.valueOf(bill);}
			amount = request.getParameter("amount");
			reason = request.getParameter("reason");
			entity.setPcn(pcn);
			entity.setId(Integer.valueOf(odid));
			entity.setTypeid(typeid);
			entity.setDate(date);
			entity.setVendor(vendor);
			entity.setReimburse(reimburse);
			entity.setBillable(billable);
			entity.setAmount(Double.parseDouble(amount));
			entity.setReason(reason);
			Da.insertTravelExpenseList(entity);
			checkin = request.getParameter("checkin");
			checkout = request.getParameter("checkout");
			entity.setCheckin(checkin);
			entity.setCheckout(checkout);
			Da.insertTravelExpenseListHotel(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpenseList&odid="+odid);
			break;
		case "flight":
			pcn = request.getParameter("pcn");
			odid = request.getParameter("odid");
			type = request.getParameter("type");
			if(type != null){
				typeid = Integer.valueOf(type);
			}
			date = request.getParameter("date");
			vendor = request.getParameter("vendor");
			reimb = request.getParameter("reimb");
			if(reimb != null){
				reimburse = Integer.valueOf(reimb);}
				bill = request.getParameter("billable");
			if(bill != null){
				billable = Integer.valueOf(bill);}
			amount = request.getParameter("amount");
			reason = request.getParameter("reason");
			departure = request.getParameter("departure");
			returns = request.getParameter("return");
			stop = request.getParameter("stopover");
			if(stop != null){
			stopover = Integer.valueOf(stop);}
			from = request.getParameter("from");
			to = request.getParameter("to");
			entity.setPcn(pcn);
			entity.setId(Integer.valueOf(odid));
			entity.setTypeid(typeid);
			entity.setDate(date);
			entity.setVendor(vendor);
			entity.setReimburse(reimburse);
			entity.setBillable(billable);
			entity.setAmount(Double.parseDouble(amount));
			entity.setReason(reason);
			Da.insertTravelExpenseList(entity);
			entity.setStopover(stopover);
			entity.setDeparture(departure);
			entity.setReturns(returns);
			entity.setFfrom(from);
			entity.setFto(to);
			Da.insertTravelExpenseListFlight(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpenseList&odid="+odid);
			break;
		case "mileage":
			pcn = request.getParameter("pcn");
			odid = request.getParameter("odid");
			type = request.getParameter("type");
			if(type != null){
				typeid = Integer.valueOf(type);
			}
			date = request.getParameter("date");
			reimb = request.getParameter("reimb");
			if(reimb != null){
				reimburse = Integer.valueOf(reimb);}
				bill = request.getParameter("billable");
			if(bill != null){
				billable = Integer.valueOf(bill);}
			amount = request.getParameter("amount");
			reason = request.getParameter("reason");
			from = request.getParameter("from");
			to = request.getParameter("to");
			distance = request.getParameter("distance");
			entity.setPcn(pcn);
			entity.setId(Integer.valueOf(odid));
			entity.setTypeid(typeid);
			entity.setDate(date);
			entity.setReimburse(reimburse);
			entity.setBillable(billable);
			entity.setAmount(Double.parseDouble(amount));
			entity.setReason(reason);
			Da.insertTravelExpenseList(entity);
			entity.setMfrom(from);
			entity.setMto(to);
			entity.setDistance(Integer.valueOf(distance));
			Da.insertTravelExpenseListMileage(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpenseList&odid="+odid);
			break;
		case "meal":
			pcn = request.getParameter("pcn");
			odid = request.getParameter("odid");
			type = request.getParameter("type");
			if(type != null){
				typeid = Integer.valueOf(type);
			}
			date = request.getParameter("date");
			vendor = request.getParameter("vendor");
			description = request.getParameter("description");
			reimb = request.getParameter("reimb");
			if(reimb != null){
				reimburse = Integer.valueOf(reimb);}
				bill = request.getParameter("billable");
			if(bill != null){
				billable = Integer.valueOf(bill);}
			amount = request.getParameter("amount");
			reason = request.getParameter("reason");
			entity.setPcn(pcn);
			entity.setId(Integer.valueOf(odid));
			entity.setTypeid(typeid);
			entity.setDate(date);
			entity.setReimburse(reimburse);
			entity.setBillable(billable);
			entity.setAmount(Double.parseDouble(amount));
			entity.setReason(reason);
			Da.insertTravelExpenseList(entity);
			entity.setMvendor(vendor);
			entity.setDescription(description);
			Da.insertTravelExpenseListMeal(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpenseList&odid="+odid);
			break;
		case "miscellaneous":
			pcn = request.getParameter("pcn");
			odid = request.getParameter("odid");
			type = request.getParameter("type");
			if(type != null){
				typeid = Integer.valueOf(type);
			}
			date = request.getParameter("date");
			vendor = request.getParameter("vendor");
			description = request.getParameter("description");
			reimb = request.getParameter("reimb");
			if(reimb != null){
				reimburse = Integer.valueOf(reimb);}
				bill = request.getParameter("billable");
			if(bill != null){
				billable = Integer.valueOf(bill);}
			amount = request.getParameter("amount");
			reason = request.getParameter("reason");
			entity.setPcn(pcn);
			entity.setId(Integer.valueOf(odid));
			entity.setTypeid(typeid);
			entity.setDate(date);
			entity.setReimburse(reimburse);
			entity.setBillable(billable);
			entity.setAmount(Double.parseDouble(amount));
			entity.setReason(reason);
			Da.insertTravelExpenseList(entity);
			entity.setMiscvendor(vendor);
			entity.setDescription(description);
			Da.insertTravelExpenseListMisc(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpenseList&odid="+odid);
			break;
		}
		doGet(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double maxbud = 0, receipt = 0, maxexp=0;
		int expense, days = 0;
		PrintWriter out= response.getWriter();
		ArrayList<TravelExpenseEntity> travelexpense = null;
		ArrayList<TravelExpenseListEntity> travelexpenselist = null;
		ArrayList<CompanyPolicyEntity> policylist = null;
		ArrayList<CurrencyEntity> currencylist = null;
		policylist = DaPolicy.getPolicy();
		currencylist = DaCurrency.getCurrencyList();
		/*for(int i=0; policylist.size() > i; i++){
			CompanyPolicyEntity data = policylist.get(i);
			days =  data.getExpensedays();
			maxbud = data.getMaxbudget();
			receipt = data.getReceiptamount();
			maxexp = data.getMaxexpense();
		}*/
		odid = request.getParameter("odid");
		travelexpense = Da.getTravelExpenseByOrderId(Integer.valueOf(odid));
		travelexpenselist = Da.getTravelExpenseListByOrderId(Integer.valueOf(odid));
		request.setAttribute("currencylist", currencylist);
		request.setAttribute("policylist", policylist);
		request.setAttribute("travelexpense", travelexpense);
		request.setAttribute("travelexpenselist", travelexpenselist);
		rd = request.getRequestDispatcher("T-Travelexpenselist.jsp");
		rd.include(request, response);
	}

}
