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

import com.HelperClasses.Helper;
import com.TravelDa.ApprovingOfficerDa;
import com.TravelDa.EmployeeDa;
import com.TravelDa.TravelOrderDa;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.TravelOrderEntity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONObject;

/**
 * Servlet implementation class TravelOrderApprovingOfficer
 */
@WebServlet("/TravelOrderOfficer")
public class TravelOrderOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Helper helper;
	private TravelOrderEntity entity;
	private TravelOrderDa toda;
	private RequestDispatcher rd;
	private EmployeeDa Employee;
	private ApprovingOfficerDa OffDa;
	private ArrayList<EmployeeInformationEntity> Employeelist;
	private ArrayList<TravelOrderEntity> TravelOrderlist;
	private String comment, form;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelOrderOfficer() {
        // TODO Auto-generated constructor stub
    	toda = new TravelOrderDa();
    	entity = new TravelOrderEntity();
    	OffDa = new ApprovingOfficerDa();
        helper = new Helper();
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
				toda.insertComment(entity);
			response.sendRedirect("Redirect?servletpage=TravelOrderOfficer");
			break;
		case "addStatus":
			OffDa = new ApprovingOfficerDa();
			String status = request.getParameter("status");
			int statusid = Integer.valueOf(status);
			String myid = request.getParameter("id");
			int offid = OffDa.getApprovingOfficerId(eid);
			try {
				//if(offid > 0){
				JSONArray array = new JSONArray(myid);
				for(int i=0; i<array.length(); i++){
						entity = new TravelOrderEntity();
						toda = new TravelOrderDa();
						entity.setId(Integer.valueOf(array.getString(i)));
						entity.setStatusid(statusid);
						entity.setOfficerid(offid);
						toda.insertStatus(entity);
			}
				//}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//response.sendRedirect("Redirect?servletpage=TravelOrderOfficer");
			break;
		case "getComment":
			toda = new TravelOrderDa();
			ArrayList<TravelOrderEntity> commlist;
			String ids = request.getParameter("id");
			commlist = toda.getCommentById(Integer.valueOf(ids));
			String jsons = new Gson().toJson(commlist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			    return;
			} else {
				System.out.print("Tonolist empty jsonss");
			}
			response.sendRedirect("Redirect?servletpage=TravelOrderOfficer");
			break;
		}
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		toda = new TravelOrderDa();
		TravelOrderlist =  toda.getTravelOrderList();
			request.setAttribute("travelorderlist", TravelOrderlist);
			rd = request.getRequestDispatcher("T-TravelorderOfficer.jsp");
			rd.include(request, response);
	}

}
