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

import com.TravelDa.TravelExpenseDa;
import com.TravelEntity.TravelExpenseEntity;
import com.TravelEntity.TravelOrderEntity;

/**
 * Servlet implementation class TravelExpensePersonnel
 */
@WebServlet("/TravelExpensePersonnel")
public class TravelExpensePersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TravelExpenseDa TEDa;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelExpensePersonnel() {
        // TODO Auto-generated constructor stub
    	TEDa = new TravelExpenseDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empid = (String) session.getAttribute("empid");
		int eid = Integer.valueOf(empid);
		ArrayList<TravelExpenseEntity> expenselist=null;
		expenselist = TEDa.getTravelExpensePersonnel(eid);
		request.setAttribute("explist", expenselist);
		rd = request.getRequestDispatcher("T-TravelexpensePersonnel.jsp");
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
