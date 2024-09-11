package com.Personnel;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TravelDa.TravelOrderDa;
import com.TravelEntity.TravelOrderEntity;

/**
 * Servlet implementation class TravelOrderQueryPersonnel
 */
@WebServlet("/TravelOrderQueryPersonnel")
public class TravelOrderQueryPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TravelOrderEntity toentity;
	private TravelOrderDa toda;
	private RequestDispatcher rd;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelOrderQueryPersonnel() {
    	 toda = new TravelOrderDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empid = (String) session.getAttribute("empid");
		int eid = Integer.valueOf(empid);
		toda = new TravelOrderDa();
		ArrayList<TravelOrderEntity> list =  toda.getTravelOrderListEmployee(eid);
		if(list.size() > 0){
			request.setAttribute("travelorderlist", list);
			rd = request.getRequestDispatcher("Q-TravelorderlistPersonnel.jsp");
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
