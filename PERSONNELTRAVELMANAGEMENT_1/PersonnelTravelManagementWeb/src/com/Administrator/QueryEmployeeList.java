package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.EmployeeDa;
import com.TravelEntity.EmployeeInformationEntity;

/**
 * Servlet implementation class QueryEmployeeList
 */
@WebServlet("/QueryEmployeeList")
public class QueryEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDa Da;
    private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryEmployeeList() {
    	 Da = new EmployeeDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<EmployeeInformationEntity>Employeeis = null;
		Employeeis = Da.getAllEmployeeInformation();
		request.setAttribute("jspemplist", Employeeis);
		rd = request.getRequestDispatcher("Q-Employeelist.jsp");
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
