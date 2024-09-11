package com.ApprovingOfficer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.TravelPlanDa;
import com.TravelEntity.TravelPlanEntity;

/**
 * Servlet implementation class TravelPlanReportOfficer
 */
@WebServlet("/TravelPlanReportOfficer")
public class TravelPlanReportOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    private TravelPlanEntity entity;
    private TravelPlanDa Da;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlanReportOfficer() {
    	entity = new TravelPlanEntity();
    	Da = new TravelPlanDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Da = new TravelPlanDa();
		ArrayList<TravelPlanEntity> planlistreport = null;
		planlistreport = Da.getTravelPlanListReport();
		request.setAttribute("planlistreport",planlistreport);	
		rd = request.getRequestDispatcher("R-TravelplanOfficer.jsp");
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
