package com.Administrator;

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
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DashboardDa Da;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public Dashboard() {
    	Da = new DashboardDa();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ArrayList<DashboardEntity> ToApprove, ToCancel, Plan, Expense;
		ArrayList<ChartEntity> Aexpense, Atravel;
		ToApprove = Da.getTOapprove();
		ToCancel = Da.getTOcancel();
		Plan = Da.getTOplan();
		Expense = Da.getTOexpense();
		Aexpense = Da.getAnalyticExpense();
		Atravel = Da.getAnalyticTravel();
		//String datas = null;
			//for(int i=0; i<Aexpense.size(); i++){
			//	DashboardEntity data = Aexpense.get(i);
				 //data.getDate(); data.getValue();
			//		datas += "x:"+data.getDate() + "y:"+data.getValue();
			//}
			//request.setAttribute("Aexpense", Aexpense);
			request.setAttribute("ToApprove", ToApprove);
			request.setAttribute("ToCancel", ToCancel);
			request.setAttribute("Plan", Plan);
			request.setAttribute("Expense", Expense);
			String jsons = new Gson().toJson(Aexpense);
			String jsons2 = new Gson().toJson(Atravel);
			if (jsons.trim().length() > 0) {
				request.setAttribute("Aexpense", jsons);
				request.setAttribute("Atravel", jsons2);
			}
			rd = request.getRequestDispatcher("Dashboard.jsp");
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
