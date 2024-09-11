package com.ApprovingOfficer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.DashboardDa;
import com.TravelEntity.ChartEntity;
import com.TravelEntity.DashboardEntity;


import com.google.gson.*;
/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/DashboardOfficer")
public class DashboardOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DashboardDa Da;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardOfficer() {
    	Da = new DashboardDa();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//byte[] sample = Base64.encodeBase64(binaryData);
		PrintWriter out = response.getWriter();
		ArrayList<DashboardEntity> topend, planpend, exppend;
		ArrayList<ChartEntity> Aexpense, Atravel;
		topend =  Da.getToPending();
		planpend = Da.getPlanPending();
		exppend = Da.getExpensePending();
		Aexpense = Da.getAnalyticExpense();
		Atravel = Da.getAnalyticTravel();
			request.setAttribute("topend", topend);
			request.setAttribute("planpend", planpend);
			request.setAttribute("exppend", exppend);
			String jsons = new Gson().toJson(Aexpense);
			String jsons2 = new Gson().toJson(Atravel);
			if (jsons.trim().length() > 0) {
				request.setAttribute("Aexpense", jsons);
				request.setAttribute("Atravel", jsons2);
			}
			rd = request.getRequestDispatcher("DashboardOfficer.jsp");
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
