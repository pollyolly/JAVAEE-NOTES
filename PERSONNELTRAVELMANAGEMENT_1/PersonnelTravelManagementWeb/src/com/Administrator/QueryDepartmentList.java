package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.DepartmentDa;
import com.TravelEntity.DepartmentEntity;

/**
 * Servlet implementation class QueryDepartmentList
 */
@WebServlet("/QueryDepartmentList")
public class QueryDepartmentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private DepartmentDa Da;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryDepartmentList() {
    	Da = new DepartmentDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<DepartmentEntity> deptlist = null;
		deptlist = Da.getAllDepartment();
		request.setAttribute("deptlist", deptlist);
		rd = request.getRequestDispatcher("Q-Departmentlist.jsp");
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
