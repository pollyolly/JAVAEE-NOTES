package com.Administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HelperClasses.Helper;
import com.TravelDa.PositionDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.PositionEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class Position
 */
@WebServlet("/Position")
public class Position extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Helper helper;
	private PositionDa data;
	private PositionEntity entity;
	private RequestDispatcher rd;
	private StatusDa Status;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Position() {
        super();
        // TODO Auto-generated constructor stub
        data = new PositionDa();
        entity = new PositionEntity();
        helper = new Helper();
        Status = new StatusDa();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String form, sposition, sdescription;
		int ipositionid, istatusid, myid;
		form = request.getParameter("forms");
		switch(form){
		case "insertPosition":
			sposition = request.getParameter("position");
			sdescription = request.getParameter("description");
			istatusid  = helper.toInt(request.getParameter("status"));
			entity.setPosition(sposition);
			entity.setDescription(sdescription);
			entity.setStatusid(istatusid);
			data.insertPosition(entity);
			response.sendRedirect("Redirect?servletpage=Position");
			break;
		case "updatePosition":
			sposition = helper.toString(request.getParameter("position2"));
			sdescription = helper.toString(request.getParameter("description2"));
			istatusid  = helper.toInt(request.getParameter("status2"));
			ipositionid = helper.toInt(request.getParameter("positionid"));
			entity.setPosition(sposition);
			entity.setDescription(sdescription);
			entity.setStatusid(istatusid);
			entity.setPositionid(ipositionid);
			data.updatePosition(entity);
			response.sendRedirect("Redirect?servletpage=Position");
			break;
		case "editForm":
			data = new PositionDa();
			ArrayList<PositionEntity> positionlist;
			myid = helper.toInt(request.getParameter("positionid"));
			positionlist = data.getPositionListById(myid);
			String jsons = new Gson().toJson(positionlist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
			} else {
				System.out.print("Positionbyid empty jsonss");
			}
			break;
		}
		list(request, response);
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<PositionEntity> positionlist;
		ArrayList<StatusEntity> statuslist =  Status.getStatus();
		positionlist = data.getAllPositionList();
			request.setAttribute("jspStatuslist", statuslist);
			request.setAttribute("jspPositionlist", positionlist);
			rd = request.getRequestDispatcher("S-Position.jsp");
			rd.include(request, response);
	}
	
}
