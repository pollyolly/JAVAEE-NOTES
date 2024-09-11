package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.CashAdvanceDa;
import com.TravelEntity.CashAdvanceEntity;

/**
 * Servlet implementation class CashAdvanceReport
 */
@WebServlet("/CashAdvanceReport")
public class CashAdvanceReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CashAdvanceEntity caentity;
	private CashAdvanceDa cada;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashAdvanceReport() {
        super();
        // TODO Auto-generated constructor stub
        caentity = new CashAdvanceEntity();
        cada = new CashAdvanceDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CashAdvanceEntity> list =  cada.getCashAdvanceList();

			request.setAttribute("cashadvancelist", list);
			rd = request.getRequestDispatcher("R-Cashadvancelist.jsp");
			rd.include(request, response);

	}
}
