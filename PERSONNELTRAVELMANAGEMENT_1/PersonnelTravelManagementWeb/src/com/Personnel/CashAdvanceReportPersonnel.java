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

import com.TravelDa.CashAdvanceDa;
import com.TravelEntity.CashAdvanceEntity;

/**
 * Servlet implementation class CashAdvanceReportPersonnel
 */
@WebServlet("/CashAdvanceReportPersonnel")
public class CashAdvanceReportPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CashAdvanceEntity caentity;
	private CashAdvanceDa cada;
	private RequestDispatcher rd;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashAdvanceReportPersonnel() {
    	caentity = new CashAdvanceEntity();
        cada = new CashAdvanceDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empid = (String) session.getAttribute("empid");
		int eid = Integer.valueOf(empid);
		cada = new CashAdvanceDa();
		ArrayList<CashAdvanceEntity> list =  cada.getCashAdvanceList();
		if(list.size() > 0){
			request.setAttribute("cashadvancelist", list);
			rd = request.getRequestDispatcher("R-CashadvancelistPersonnel.jsp");
			rd.include(request, response);
		} else {
			System.out.print("Empty list");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
