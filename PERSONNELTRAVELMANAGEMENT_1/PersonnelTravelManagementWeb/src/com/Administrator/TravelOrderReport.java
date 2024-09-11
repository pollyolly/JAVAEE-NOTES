package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.TravelOrderDa;
import com.TravelEntity.TravelOrderEntity;

/**
 * Servlet implementation class TravelOrderReport
 */
@WebServlet("/TravelOrderReport")  
public class TravelOrderReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TravelOrderEntity toentity;
	private TravelOrderDa toda;
	private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelOrderReport() {
        // TODO Auto-generated constructor stub
        toentity = new TravelOrderEntity();
        toda = new TravelOrderDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<TravelOrderEntity> list =  toda.getTravelOrderList();
			request.setAttribute("travelorderlist", list);
			rd = request.getRequestDispatcher("R-Travelorderlist.jsp");
			rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
