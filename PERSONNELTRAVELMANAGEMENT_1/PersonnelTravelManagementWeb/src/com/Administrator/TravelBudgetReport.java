package com.Administrator;

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
 * Servlet implementation class TravelBudgetReport
 */
@WebServlet("/TravelBudgetReport")
public class TravelBudgetReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    private TravelBudgetDa Da;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelBudgetReport() {
        super();
        // TODO Auto-generated constructor stub
        Da = new TravelBudgetDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelBudgetEntity> budgetlist = Da.getBudgetList();
		request.setAttribute("budgetlist", budgetlist);
		rd = request.getRequestDispatcher("R-Budgetlist.jsp");
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
