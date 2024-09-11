package com.Administrator;

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
 * Servlet implementation class TravelPlanReport
 */
@WebServlet("/TravelPlanReport")
public class TravelPlanReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    private TravelPlanEntity entity;
    private TravelPlanDa Da;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlanReport() {
        // TODO Auto-generated constructor stub
    	entity = new TravelPlanEntity();
    	Da = new TravelPlanDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelPlanEntity> planlistreport = null;
		planlistreport = Da.getTravelPlanListReport();
		request.setAttribute("planlistreport",planlistreport);	
		rd = request.getRequestDispatcher("R-Travelplan.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
