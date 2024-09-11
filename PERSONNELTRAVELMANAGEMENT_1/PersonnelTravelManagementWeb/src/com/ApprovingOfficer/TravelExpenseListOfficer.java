package com.ApprovingOfficer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.CompanyPolicyDa;
import com.TravelDa.TravelExpenseDa;
import com.TravelEntity.CompanyPolicyEntity;
import com.TravelEntity.TravelExpenseEntity;
import com.TravelEntity.TravelExpenseListEntity;

/**
 * Servlet implementation class TravelExpenseListOfficer
 */
@WebServlet("/TravelExpenseListOfficer")
public class TravelExpenseListOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TravelExpenseDa Da;
	private TravelExpenseListEntity entity;
	private RequestDispatcher rd;
	private String form, odid;
	private CompanyPolicyDa DaPolicy;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelExpenseListOfficer() {
    	entity = new TravelExpenseListEntity();
    	Da = new TravelExpenseDa();
    	DaPolicy = new CompanyPolicyDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CompanyPolicyEntity> policylist = null;
		policylist = DaPolicy.getPolicy();
		Da = new TravelExpenseDa();
		ArrayList<TravelExpenseEntity> travelexpense = null;
		ArrayList<TravelExpenseListEntity> travelexpenselist = null;
		odid = request.getParameter("odid");
		travelexpense = Da.getTravelExpenseByOrderId(Integer.valueOf(odid));
		travelexpenselist = Da.getTravelExpenseListByOrderId(Integer.valueOf(odid));
		request.setAttribute("policylist", policylist);
		request.setAttribute("travelexpense", travelexpense);
		request.setAttribute("travelexpenselist", travelexpenselist);
		rd = request.getRequestDispatcher("T-TravelexpenselistOfficer.jsp");
		rd.include(request, response);
	}
}
