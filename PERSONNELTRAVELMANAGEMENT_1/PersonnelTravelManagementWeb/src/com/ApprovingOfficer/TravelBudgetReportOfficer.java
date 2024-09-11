package com.ApprovingOfficer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.TravelBudgetDa;
import com.TravelEntity.TravelBudgetEntity;

/**
 * Servlet implementation class TravelBudgetReportOfficer
 */
@WebServlet("/TravelBudgetReportOfficer")
public class TravelBudgetReportOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    private TravelBudgetDa Da;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelBudgetReportOfficer() {
    	Da = new TravelBudgetDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Da = new TravelBudgetDa();
		ArrayList<TravelBudgetEntity> budgetlist = Da.getBudgetList();
		request.setAttribute("budgetlist", budgetlist);
		rd = request.getRequestDispatcher("R-BudgetlistOfficer.jsp");
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
