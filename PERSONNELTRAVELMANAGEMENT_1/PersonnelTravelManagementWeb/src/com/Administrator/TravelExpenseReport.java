package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.TravelExpenseDa;
import com.TravelEntity.TravelExpenseEntity;

/**
 * Servlet implementation class TravelExpenseReport
 */
@WebServlet("/TravelExpenseReport")
public class TravelExpenseReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TravelExpenseDa Da;
    private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelExpenseReport() {
        // TODO Auto-generated constructor stub
    	Da = new TravelExpenseDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelExpenseEntity> travelexpensereport = null;
		travelexpensereport = Da.getTravelExpenseListReport();
		request.setAttribute("travelexpensereport", travelexpensereport);
		rd = request.getRequestDispatcher("R-Travelexpense.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
