package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.ApprovingOfficerDa;
import com.TravelEntity.ApprovingOfficerEntity;

/**
 * Servlet implementation class QueryApprovingOfficerList
 */
@WebServlet("/QueryApprovingOfficerList")
public class QueryApprovingOfficerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ApprovingOfficerDa Da;
    private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryApprovingOfficerList() {
    	Da = new ApprovingOfficerDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ApprovingOfficerEntity> Alllist = null;
		Alllist = Da.getAllApprovingOfficer();
		request.setAttribute("alllist", Alllist);
		rd = request.getRequestDispatcher("Q-Approvingofficerlist.jsp");
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
