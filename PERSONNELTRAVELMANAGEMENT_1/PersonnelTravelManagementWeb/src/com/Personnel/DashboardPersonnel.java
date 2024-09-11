package com.Personnel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TravelDa.DashboardDa;
import com.TravelEntity.ChartEntity;
import com.TravelEntity.DashboardEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class DashboardPersonnel
 */
@WebServlet("/DashboardPersonnel")
public class DashboardPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DashboardDa Da;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardPersonnel() {
        // TODO Auto-generated constructor stub
    	Da = new DashboardDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empid = (String) session.getAttribute("empid");
		int eid = Integer.valueOf(empid);
		ArrayList<DashboardEntity> exppend, expapp, expnot;
		ArrayList<ChartEntity> Aexpense, Atravel;
		exppend =  Da.getExpensePendingPersonnel(eid);
		expapp = Da.getExpenseApprovePersonnel(eid);
		expnot = Da.getExpenseNotapprovePersonnel(eid);
		Aexpense = Da.getAnalyticExpensePersonnel(eid);
		Atravel = Da.getAnalyticTravelPersonnel(eid);
			request.setAttribute("exppend", exppend);
			request.setAttribute("expapp", expapp);
			request.setAttribute("expnot", expnot);
			String jsons = new Gson().toJson(Aexpense);
			String jsons2 = new Gson().toJson(Atravel);
			if (jsons.trim().length() > 0) {
				request.setAttribute("Aexpense", jsons);
				request.setAttribute("Atravel", jsons2);
			}
		rd = request.getRequestDispatcher("DashboardPersonnel.jsp");
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
