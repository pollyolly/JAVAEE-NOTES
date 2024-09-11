package com.ApprovingOfficer;

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
 * Servlet implementation class CashAdvanceReportOfficer
 */
@WebServlet("/CashAdvanceReportOfficer")
public class CashAdvanceReportOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CashAdvanceEntity caentity;
	private CashAdvanceDa cada;
	private RequestDispatcher rd;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashAdvanceReportOfficer() {
    	caentity = new CashAdvanceEntity();
        cada = new CashAdvanceDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		cada = new CashAdvanceDa();
		ArrayList<CashAdvanceEntity> list =  cada.getCashAdvanceList();
		if(list.size() > 0){
			request.setAttribute("cashadvancelist", list);
			rd = request.getRequestDispatcher("R-CashadvancelistOfficer.jsp");
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
