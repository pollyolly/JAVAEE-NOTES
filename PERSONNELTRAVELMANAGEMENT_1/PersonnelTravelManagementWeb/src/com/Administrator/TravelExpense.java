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

import com.TravelDa.TravelExpenseDa;
import com.TravelDa.TravelOrderDa;
import com.TravelDa.TravelPlanDa;
import com.TravelEntity.TravelExpenseEntity;
import com.TravelEntity.TravelOrderEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class TravelExpense
 */
@WebServlet("/TravelExpense")
public class TravelExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private TravelOrderDa ToDa;
	private TravelExpenseDa TEDa;
	private String form, fromdate, todate, odid;
	private TravelExpenseEntity entity;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelExpense() {
        // TODO Auto-generated constructor stub
    	entity = new TravelExpenseEntity();
    	ToDa = new TravelOrderDa();
    	TEDa = new TravelExpenseDa();
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
		PrintWriter out= response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addExpense":
			fromdate = request.getParameter("fromdate");
			todate = request.getParameter("todate");
			odid = request.getParameter("employee");
			entity.setFromdate(fromdate);
			entity.setTodate(todate);
			entity.setId(Integer.valueOf(odid));
			TEDa.insertTravelExpense(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpense");
			break;
		case "popuEmployee":
			ToDa = new TravelOrderDa();
			ArrayList<TravelOrderEntity> tonolist;
			String mytono = request.getParameter("tono");
			tonolist = ToDa.getToByTono(mytono);
			String jsons = new Gson().toJson(tonolist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			} else {
				System.out.print("Tonolist empty jsonss");
			}
			break;
		}
		list(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelExpenseEntity> expenselist=null;
		ArrayList<TravelOrderEntity> tonolist=null;
		tonolist = ToDa.getTOno();
		expenselist = TEDa.getTravelExpense();
		request.setAttribute("tolist", tonolist);
		request.setAttribute("explist", expenselist);
		rd = request.getRequestDispatcher("T-Travelexpense.jsp");
		rd.include(request, response);
	}
}
