package com.Administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.LogsDa;
import com.TravelEntity.LogsEntity;

/**
 * Servlet implementation class Logs
 */
@WebServlet("/Logs")
public class Logs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LogsDa Da;
       private LogsEntity entity;
       private RequestDispatcher rd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logs() {
        Da = new LogsDa();
        entity = new LogsEntity();
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<LogsEntity> logslist = null;
		logslist = Da.getLogsList();
		request.setAttribute("logslist", logslist);
		rd = request.getRequestDispatcher("C-Systemlog.jsp");
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
