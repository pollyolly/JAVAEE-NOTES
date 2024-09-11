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

import org.json.JSONArray;
import org.json.JSONException;

import com.TravelDa.CashAdvanceDa;
import com.TravelEntity.CashAdvanceEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class CashAdvanceApprovingOfficer
 */
@WebServlet("/CashAdvanceOfficer")
public class CashAdvanceOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	private CashAdvanceDa CADA;
	private String form;
	private CashAdvanceEntity entity;
	private ArrayList<CashAdvanceEntity> Cashadvancelist;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashAdvanceOfficer() {
    	CADA = new CashAdvanceDa();
    	entity = new CashAdvanceEntity();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addComment":
			String comment = request.getParameter("comment");
			String id = request.getParameter("id");
				entity.setId(Integer.valueOf(id));
				entity.setComment(comment);
				CADA.insertComment(entity);
			response.sendRedirect("Redirect?servletpage=CashAdvanceOfficer");
			break;
		case "addStatus":
			String status = request.getParameter("status");
			int statusid = Integer.valueOf(status);
			String myid = request.getParameter("id");
			try {
				JSONArray array = new JSONArray(myid);
				for(int i=0; i<array.length(); i++){
						entity = new CashAdvanceEntity();
						CADA = new CashAdvanceDa();
						entity.setId(Integer.valueOf(array.getString(i)));
						entity.setStatusid(statusid);
						entity.setOfficerid(104);
						CADA.insertStatus(entity);
			}
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//response.sendRedirect("Redirect?servletpage=TravelOrderOfficer");
			break;
		case "getComment":
			CADA = new CashAdvanceDa();
			ArrayList<CashAdvanceEntity> commlist;
			String ids = request.getParameter("id");
			commlist = CADA.getCommentById(Integer.valueOf(ids));
			String jsons = new Gson().toJson(commlist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			    return;
			} else {
				System.out.print("CAlist empty jsonss");
			}
			break;
		}
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CADA = new CashAdvanceDa();
		Cashadvancelist = CADA.getCashAdvanceList();
			request.setAttribute("calist", Cashadvancelist);
			rd = request.getRequestDispatcher("T-CashadvanceOfficer.jsp");
			rd.include(request, response);

	}

}
