package com.ApprovingOfficer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;

import com.TravelDa.ApprovingOfficerDa;
import com.TravelDa.TravelPlanDa;
import com.TravelEntity.TravelPlanEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class TravelPlanApprovingOfficer
 */
@WebServlet("/TravelPlanOfficer")
public class TravelPlanOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TravelPlanDa Da;
	private RequestDispatcher rd;
	private ArrayList<TravelPlanEntity> planlist;
	private TravelPlanEntity entity;
	private String form;
	private ApprovingOfficerDa OffDa;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelPlanOfficer() {
    	Da = new TravelPlanDa();
    	entity = new TravelPlanEntity();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empid = (String) session.getAttribute("empid");
		int eid = Integer.valueOf(empid);
		PrintWriter out= response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addComment":
			String comment = request.getParameter("comment");
			String id = request.getParameter("id");
				entity.setId(Integer.valueOf(id));
				entity.setComment(comment);
				Da.insertComment(entity);
			response.sendRedirect("Redirect?servletpage=TravelPlanOfficer");
			break;
		case "addStatus":
			String status = request.getParameter("status");
			int statusid = Integer.valueOf(status);
			String myid = request.getParameter("id");
			try {
				OffDa = new ApprovingOfficerDa();
				int offid = OffDa.getApprovingOfficerId(eid);
				if(offid > 0){
				JSONArray array = new JSONArray(myid);
				for(int i=0; i<array.length(); i++){
						entity = new TravelPlanEntity();
						Da = new TravelPlanDa();
						entity.setId(Integer.valueOf(array.getString(i)));
						entity.setStatusid(statusid);
						entity.setOfficerid(offid);
						Da.insertStatus(entity);
			}}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("Redirect?servletpage=TravelPlanOfficer");
			break;
		case "getComment":
			Da = new TravelPlanDa();
			ArrayList<TravelPlanEntity> commlist;
			String ids = request.getParameter("id");
			commlist = Da.getCommentById(Integer.valueOf(ids));
			String jsons = new Gson().toJson(commlist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			    return;
			} else {
				System.out.print("Planlist empty jsonss");
			}
			response.sendRedirect("Redirect?servletpage=TravelPlanOfficer");
			break;
		}
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Da = new TravelPlanDa();
		planlist = Da.getTravelPlanList();
		request.setAttribute("planlist", planlist);
		rd = request.getRequestDispatcher("T-TravelplanOfficer.jsp");
		rd.include(request, response);
	}
}
