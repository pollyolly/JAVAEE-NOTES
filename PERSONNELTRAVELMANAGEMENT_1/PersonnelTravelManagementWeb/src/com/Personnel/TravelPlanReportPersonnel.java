package com.Personnel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TravelDa.TravelPlanDa;
import com.TravelEntity.TravelPlanEntity;

/**
 * Servlet implementation class TravelPlanReportPersonnel
 */
@WebServlet("/TravelPlanReportPersonnel")
public class TravelPlanReportPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    private TravelPlanEntity entity;
    private TravelPlanDa Da;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlanReportPersonnel() {
    	entity = new TravelPlanEntity();
    	Da = new TravelPlanDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empid = (String) session.getAttribute("empid");
		int eid = Integer.valueOf(empid);
		Da = new TravelPlanDa();
		ArrayList<TravelPlanEntity> planlistreport = null;
		planlistreport = Da.getTravelPlanListReportEmployee(eid);
		request.setAttribute("planlistreport",planlistreport);	
		rd = request.getRequestDispatcher("R-TravelplanPersonnel.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
