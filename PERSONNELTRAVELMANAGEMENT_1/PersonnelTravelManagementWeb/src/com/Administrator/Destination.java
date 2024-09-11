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

import com.TravelDa.DestinationDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.CurrencyEntity;
import com.TravelEntity.DestinationEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;

/**
 * Servlet implementation class Destination
 */
@WebServlet("/Destination")
public class Destination extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DestinationDa destda;
    private DestinationEntity entity;
    private StatusDa statda;
    private RequestDispatcher rd;
    private boolean alertStatus;
    private String message = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destination() {
        // TODO Auto-generated constructor stub
    	statda = new StatusDa();
    	entity = new DestinationEntity();
    	destda = new DestinationDa();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String form, code, city, state, country, status, id;
		int statusid, ids;
		form = request.getParameter("forms");
		code = request.getParameter("code");
		city = request.getParameter("city");
		state = request.getParameter("state");
		country = request.getParameter("country");
		status = request.getParameter("status");
		id = request.getParameter("id");
		switch(form) {
		case "addDestination":
			statusid = Integer.valueOf(status);
			entity.setCode(code);
			entity.setCity(city);
			entity.setState(state);
			entity.setCountry(country);
			entity.setStatusid(statusid);
			if(destda.insertDestination(entity)==1){
				message ="Successfully Insert Destination!";
				alertStatus = true;
			}else{
				message ="Failed Insert Destination!";
				alertStatus = false;
			}
			response.sendRedirect("Redirect?servletpage=Destination&alertStatus="+alertStatus+"&message="+message);
		break;	
		case "updateDestination":
			code = request.getParameter("code2");
			city = request.getParameter("city2");
			state = request.getParameter("state2");
			country = request.getParameter("country2");
			status = request.getParameter("status2");
			id = request.getParameter("destinationid");
			ids = Integer.valueOf(id);
			statusid = Integer.valueOf(status);
			entity.setCode(code);
			entity.setCity(city);
			entity.setState(state);
			entity.setCountry(country);
			entity.setStatusid(statusid);
			entity.setId(ids);
			if(destda.updateDestination(entity)==1){
				message ="Successfully Update Destination!";
				alertStatus = true;
			}else{
				message ="Failed Update Destination!";
				alertStatus = false;
				}
			response.sendRedirect("Redirect?servletpage=Destination&alertStatus="+alertStatus+"&message="+message);
			break;	
		case "editForm":
			destda = new DestinationDa();
			ArrayList<DestinationEntity> destbyid;
			ids = Integer.valueOf(id);
			destbyid = destda.getDestinationById(ids);
			String jsons = new Gson().toJson(destbyid);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
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
		ArrayList<StatusEntity>statlist = null;
		ArrayList<DestinationEntity>destlist = null;
				statlist = statda.getStatus();
				destlist = destda.getDestinationList();

					request.setAttribute("statlist", statlist);
					request.setAttribute("destlist", destlist);
					rd = request.getRequestDispatcher("C-Destination.jsp");
					rd.include(request, response);
	}


}
