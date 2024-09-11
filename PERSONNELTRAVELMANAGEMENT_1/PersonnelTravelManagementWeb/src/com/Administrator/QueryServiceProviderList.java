package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.ServiceProviderDa;
import com.TravelEntity.ServiceProviderEntity;

/**
 * Servlet implementation class QueryServiceProviderList
 */
@WebServlet("/QueryServiceProviderList")
public class QueryServiceProviderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceProviderDa Da;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServiceProviderList() {
    	Da = new ServiceProviderDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ServiceProviderEntity> splist = null;
		splist = Da.getServiceProvider();
		request.setAttribute("splist", splist);
		rd = request.getRequestDispatcher("Q-Serviceproviderlist.jsp");
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
