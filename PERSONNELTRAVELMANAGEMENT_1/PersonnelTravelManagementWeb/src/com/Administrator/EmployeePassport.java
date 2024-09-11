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

import com.TravelDa.EmployeeDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.EmployeePassportEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;
import com.HelperClasses.Helper;
/**
 * Servlet implementation class Employee
 */
@WebServlet("/EmployeePassport")
public class EmployeePassport extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String form;
    private EmployeeDa data;
    private EmployeePassportEntity entity;
    Helper Helper;
    private RequestDispatcher rd;
    private StatusDa Status;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeePassport() {
        // TODO Auto-generated constructor stub
        data = new EmployeeDa();
        entity = new EmployeePassportEntity();
        Status = new StatusDa();
        Helper = new Helper();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  passno, expdate;
		int id, statusid, empid;
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addPassport":
			empid = Helper.toInt(request.getParameter("employee"));
			statusid = Helper.toInt(request.getParameter("status"));
			passno = request.getParameter("passport");
			expdate = request.getParameter("expirationdate");
			entity.setEmployeeid(empid);
			entity.setPassportno(passno);
			entity.setExpirydate(expdate);
			entity.setStatusid(statusid);
			data.insertEmployeePassport(entity);
			response.sendRedirect("Redirect?servletpage=EmployeePassport");
			//System.out.print();
			break;
		case "updatePassport":
			id = Helper.toInt(request.getParameter("id"));
			empid = Helper.toInt(request.getParameter("employee2"));
			statusid = Helper.toInt(request.getParameter("status2"));
			passno = request.getParameter("passport2");
			expdate = request.getParameter("expirationdate2");
			entity.setPassportid(id);
			entity.setPassportno(passno);
			entity.setExpirydate(expdate);
			entity.setEmployeeid(empid);
			entity.setStatusid(statusid);
			data.updateEmployeePassport(entity);
			response.sendRedirect("Redirect?servletpage=EmployeePassport");
			break;
		case "editForm":
			ArrayList<EmployeePassportEntity> empbyid;
			int myid = Helper.toInt(request.getParameter("passid"));
			empbyid = data.getEmployeePassportById(myid);
			String jsons = new Gson().toJson(empbyid);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
			} else {
				System.out.print("Department empty jsonss");
			}
			break;
		default:
			System.out.print("Empty values on switch case");
			break;
		}
		list(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<EmployeePassportEntity> passlist;
		ArrayList<EmployeeInformationEntity> emplist;
		ArrayList<StatusEntity>statlist = Status.getStatus();
		passlist = data.getEmployeePassportList();
		emplist = data.getEmployee();
			request.setAttribute("statlist", statlist);
			request.setAttribute("emplist", emplist);
			request.setAttribute("passlist", passlist);
			rd = request.getRequestDispatcher("S-EmployeePassport.jsp");
			rd.include(request, response);
	}

}
