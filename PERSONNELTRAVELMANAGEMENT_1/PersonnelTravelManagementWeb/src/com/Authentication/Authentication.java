package com.Authentication;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TravelDa.AuthenticationDa;
import com.TravelEntity.AuthenticationEntity;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuthenticationDa Da;
    private AuthenticationEntity entity;
    private boolean status = false;
    private RequestDispatcher rd;
    private String alertStatus;
    private String message = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentication() {
        // TODO Auto-generated constructor stub
    	Da = new AuthenticationDa();
    	entity = new AuthenticationEntity();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = "",password = "";
		username = request.getParameter("username");
		password = request.getParameter("password");
		HttpSession session = request.getSession();
		if(username.isEmpty() == false && password.isEmpty() == false){
			ArrayList<AuthenticationEntity> list = null;
			list = Da.getAuthentication(username, password);
			if(list.size() > 0){
			for(int i=0; i<list.size(); i++){
				if(username.equals(list.get(i).getUser().trim()) && password.equals(list.get(i).getPass().trim()) ){
				String user = list.get(i).getUser().trim();
				String role = list.get(i).getRole().trim();
				String employee = list.get(i).getEmployee().trim();
				int empid =	list.get(i).getEmployeeid();
				String myid = String.valueOf(empid);
					session.setAttribute("username", user);
					session.setAttribute("employee", employee);
					session.setAttribute("empid", myid);
					if(role.equals("Administrator")){
						response.sendRedirect("Dashboard");
					} else if(role.equals("User")){
						response.sendRedirect("DashboardPersonnel");
					} else if(role.equals("Officer")){
						response.sendRedirect("DashboardOfficer");
					}
				}else{
					message ="Account does not match!";
					alertStatus = "FAILED";
					request.setAttribute("message", message);
					request.setAttribute("alertStatus", alertStatus);
					rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				}
			}
			}else{
				message ="Account does not exists!";
				alertStatus = "FAILED";
				request.setAttribute("message", message);
				request.setAttribute("alertStatus", alertStatus);
				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		}
		else{
			message ="Please fill the blanks!";
			alertStatus = "FAILED";
			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		//doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			HttpSession session = request.getSession();
			session.removeAttribute("username");
			session.removeAttribute("employee");
			session.removeAttribute("empid");
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
}
}
