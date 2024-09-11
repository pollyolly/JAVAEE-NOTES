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
import com.TravelDa.TravelPlanDa;
import com.TravelEntity.CompanyPolicyEntity;
import com.TravelEntity.TravelPlanEntity;
import com.TravelEntity.TravelPlanListEntity;

/**
 * Servlet implementation class TravelPlanListOfficer
 */
@WebServlet("/TravelPlanListOfficer")
public class TravelPlanListOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private TravelPlanListEntity entity;
	private TravelPlanDa Da;
	private String tno="";
	 private CompanyPolicyDa DaPolicy;
	 private String planid="";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlanListOfficer() {
    	Da = new TravelPlanDa();
    	entity = new TravelPlanListEntity();
    	DaPolicy = new CompanyPolicyDa();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Da = new TravelPlanDa();
		ArrayList<TravelPlanEntity> travelplanbytono=null;
		ArrayList<TravelPlanListEntity> travelplanlist = null;
		ArrayList<CompanyPolicyEntity> policylist = null;
		policylist = DaPolicy.getPolicy();
		tno = request.getParameter("tno");
		planid = request.getParameter("tpid");
		//int tpid = Integer.valueOf(planid);
		travelplanbytono = Da.getTravelPlan(tno, planid);
		travelplanlist = Da.getTravelPlanListByToNo(tno, planid);
		//ArrayList nymArray = new ArrayList();
		String names="";
		for(int i=0; travelplanbytono.size() > i; i++){
			TravelPlanEntity data = travelplanbytono.get(i);
			names += data.getName()+", ";
			//nymArray.add(data.getName());
		//	entity1.setNames(nymArray);
		}
		request.setAttribute("policylist", policylist);
		request.setAttribute("names", names);
		request.setAttribute("plan", travelplanbytono);
		request.setAttribute("planlist", travelplanlist);
		rd = request.getRequestDispatcher("T-TravelplanlistOfficer.jsp");
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
