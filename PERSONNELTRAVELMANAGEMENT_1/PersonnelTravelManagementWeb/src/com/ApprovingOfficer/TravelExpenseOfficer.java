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
import com.TravelDa.TravelExpenseDa;
import com.TravelEntity.TravelExpenseEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class TravelExpenseApprovingOfficer
 */
@WebServlet("/TravelExpenseOfficer")
public class TravelExpenseOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private TravelExpenseDa TEDa;
	private ApprovingOfficerDa OffDa;
	private TravelExpenseEntity entity;
	private String form;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelExpenseOfficer() {
    	TEDa = new TravelExpenseDa();
    	entity = new TravelExpenseEntity();
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
				TEDa.insertComment(entity);
			response.sendRedirect("Redirect?servletpage=TravelExpenseOfficer");
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
						entity = new TravelExpenseEntity();
						TEDa = new TravelExpenseDa();
						entity.setId(Integer.valueOf(array.getString(i)));
						entity.setStatusid(statusid);
						entity.setOfficerid(offid);
						TEDa.insertStatus(entity);
						}
					}

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("Redirect?servletpage=TravelExpenseOfficer");
			break;
		case "getComment":
			TEDa = new TravelExpenseDa();
			ArrayList<TravelExpenseEntity> commlist;
			String ids = request.getParameter("id");
			commlist = TEDa.getCommentById(Integer.valueOf(ids));
			String jsons = new Gson().toJson(commlist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			    return;
			} else {
				System.out.print("Expenselist empty jsonss");
			}
			response.sendRedirect("Redirect?servletpage=TravelExpenseOfficer");
			break;
		}
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TEDa = new TravelExpenseDa();
		ArrayList<TravelExpenseEntity> expenselist=null;
		expenselist = TEDa.getTravelExpense();
		request.setAttribute("explist", expenselist);
		rd = request.getRequestDispatcher("T-TravelexpenseOfficer.jsp");
		rd.include(request, response);	
	}
	
}
