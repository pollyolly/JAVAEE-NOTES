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

import com.TravelDa.CurrencyDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.CurrencyEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class Currency
 */
@WebServlet("/Currency")
public class Currency extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StatusDa statusda;
    private CurrencyDa currencyda;
    private  String form;
    private RequestDispatcher rd;
    private CurrencyEntity entity;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Currency() {
    	statusda = new StatusDa();
    	currencyda = new CurrencyDa();
    	entity = new CurrencyEntity();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name, country, rate, status, id;
		double rates;
		int statid, ids;
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		name = request.getParameter("name");
		country = request.getParameter("country");
		rate = request.getParameter("rate");
		status = request.getParameter("status");
		id = request.getParameter("id");
		switch(form){
		case "addCurrency":
			statid = Integer.valueOf(status);
			rates = Double.parseDouble(rate);
			entity.setName(name);
			entity.setCountry(country);
			entity.setRate(rates);
			entity.setStatusid(statid);
			currencyda.insertCurrency(entity);
			response.sendRedirect("Redirect?servletpage=Currency");
		break;
		case "updateCurrency":
			name = request.getParameter("name2");
			country = request.getParameter("country2");
			rate = request.getParameter("rate2");
			status = request.getParameter("status2");
			id = request.getParameter("currencyid");
			statid = Integer.valueOf(status);
			rates = Double.parseDouble(rate);
			ids = Integer.valueOf(id);
			entity.setName(name);
			entity.setCountry(country);
			entity.setRate(rates);
			entity.setStatusid(statid);
			entity.setId(ids);
			currencyda.updateCurrency(entity);
			response.sendRedirect("Redirect?servletpage=Currency");
			break;
		case "editForm":
			currencyda = new CurrencyDa();
			ArrayList<CurrencyEntity> currencybyid;
			ids = Integer.valueOf(id);
			currencybyid = currencyda.getCurrencyById(ids);
			String jsons = new Gson().toJson(currencybyid);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
			}
			break;
		}
		doGet(request, response);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StatusEntity>statlist = null;
		ArrayList<CurrencyEntity>currencylist = null;
				statlist = statusda.getStatus();
				currencylist = currencyda.getCurrencyList();

					request.setAttribute("statlist", statlist);
					request.setAttribute("currencylist", currencylist);
					rd = request.getRequestDispatcher("C-Currency.jsp");
					rd.include(request, response);
				
	}

}
