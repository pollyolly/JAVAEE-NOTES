package com.Administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.TravelOrderDa;
import com.TravelDa.TravelPlanDa;
import com.TravelEntity.TravelOrderEntity;
import com.TravelEntity.TravelPlanEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class TravelPlan
 */
@WebServlet("/TravelPlan")
public class TravelPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private TravelPlanDa Da;
    private ArrayList<TravelPlanEntity> planlist;
    private ArrayList<TravelOrderEntity> tonolist;
    private RequestDispatcher rd;
    private TravelPlanEntity entity;
    private TravelOrderDa ToDa;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlan() {
        // TODO Auto-generated constructor stub
    	Da = new TravelPlanDa();
    	entity = new TravelPlanEntity();
    	ToDa = new TravelOrderDa();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String form, from, to, tono, food, allow, accomm, transpo, perdiem;
		PrintWriter out= response.getWriter();
		form = null;
		form = request.getParameter("forms");
		switch(form){
		case "addPlan":
			from = request.getParameter("fromdate");
			to = request.getParameter("todate");
			tono = request.getParameter("tno");
			food = request.getParameter("food");
			allow = request.getParameter("allowance");
			accomm = request.getParameter("accommodation");
			transpo = request.getParameter("transportation");
			perdiem = request.getParameter("perdiem");
			entity.setFromdate(from);
			entity.setTodate(to);
			entity.setTono(tono);
			entity.setFood(Double.parseDouble(food));
			entity.setAllowance(Double.parseDouble(allow));
			entity.setAccommodation(Double.parseDouble(accomm));
			entity.setTransportation(Double.parseDouble(transpo));
			entity.setPerdiem(Double.parseDouble(perdiem));
			Da.insertTravelPlan(entity);
			response.sendRedirect("Redirect?servletpage=TravelPlan");
			break;
		case "addComment":
			break;
		case "popuEmployee":
			ToDa = new TravelOrderDa();
			ArrayList<TravelOrderEntity> tonolist;
			String mytono = request.getParameter("tono");
			tonolist = ToDa.getToByTono(mytono);
			String jsons = new Gson().toJson(tonolist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			} else {
				System.out.print("Tonolist empty jsonss");
			}
			break;
		}
		list(request, response);
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		tonolist = ToDa.getTOno();
		planlist = Da.getTravelPlanList();
		request.setAttribute("tolist", tonolist);
		request.setAttribute("planlist", planlist);
		rd = request.getRequestDispatcher("T-Travelplan.jsp");
		rd.include(request, response);
	}
}
