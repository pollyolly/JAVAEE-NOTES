package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.ServicesDa;
import com.TravelEntity.ServicesEntity;

/**
 * Servlet implementation class QueryAirlineList
 */
@WebServlet("/QueryAirlineList")
public class QueryAirlineList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesDa SDa;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAirlineList() {
    	SDa = new ServicesDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ServicesEntity> svlist = null;
		svlist = SDa.getServicesFlight();
		request.setAttribute("svlist", svlist);
		rd = request.getRequestDispatcher("Q-Airlinelist.jsp");
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
