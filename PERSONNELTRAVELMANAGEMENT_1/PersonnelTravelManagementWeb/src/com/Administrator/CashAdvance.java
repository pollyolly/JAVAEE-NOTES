package com.Administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.CashAdvanceDa;
import com.TravelDa.EmployeeDa;
import com.TravelDa.TravelOrderDa;
import com.TravelEntity.CashAdvanceEntity;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.TravelOrderEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class CashAdvance
 */
@WebServlet("/CashAdvance")
public class CashAdvance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private CashAdvanceDa CADA;
	private TravelOrderDa TODA;
	private String form;
	private CashAdvanceEntity entity;
	private ArrayList<CashAdvanceEntity> Cashadvancelist;
	private ArrayList<TravelOrderEntity> TOCashadvancelist;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashAdvance() {
        // TODO Auto-generated constructor stub
    	CADA = new CashAdvanceDa();
    	TODA = new TravelOrderDa();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addCashAdvance":
			String emp[] = request.getParameterValues("employee");
			String amnt = request.getParameter("amount");
			String purpose = request.getParameter("purpose");
			for(int i=0; i<emp.length; i++){
				entity = new CashAdvanceEntity();
				CADA = new CashAdvanceDa();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				entity.setCadate(dateFormat.format(date));
				entity.setOrderid(Integer.valueOf(emp[i]));
				entity.setAmount(Double.valueOf(amnt));
				entity.setPurpose(purpose);
				CADA.insertCashAdvance(entity);
			}
			response.sendRedirect("Redirect?servletpage=CashAdvance");
			break;
		case "updateCashAdvance":
			break;
		case "popuEmployee":
			TODA = new TravelOrderDa();
			ArrayList<TravelOrderEntity> tonolist;
			String mytono = request.getParameter("tono");
			tonolist = TODA.getToByTono(mytono);
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
		default:
			break;
		}
		list(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cashadvancelist = CADA.getCashAdvanceList();
		TOCashadvancelist = TODA.getTOno();

			request.setAttribute("tolist", TOCashadvancelist);
			request.setAttribute("calist", Cashadvancelist);
			rd = request.getRequestDispatcher("T-Cashadvance.jsp");
			rd.include(request, response);

	}

}
