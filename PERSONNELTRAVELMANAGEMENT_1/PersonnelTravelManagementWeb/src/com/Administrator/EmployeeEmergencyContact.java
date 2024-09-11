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
import com.TravelEntity.EmployeeEmergencyContactEntity;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;
import com.HelperClasses.Helper;
/**
 * Servlet implementation class Employee
 */
@WebServlet("/EmployeeEmergencyContact")
public class EmployeeEmergencyContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String form;
    private EmployeeDa Da;
    private EmployeeEmergencyContactEntity entity;
    Helper Helper;
    private RequestDispatcher rd;
    private String id, contact, person, relationship, statid, empid;
    private String alertStatus="";
    private String message = "";
    private StatusDa Status;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEmergencyContact() {
        super();
        // TODO Auto-generated constructor stub
        Da = new EmployeeDa();
        entity = new EmployeeEmergencyContactEntity();
        Helper = new Helper();
        Status = new StatusDa();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addContact":
			contact = request.getParameter("emergencycontact");
			person = request.getParameter("personname");
			relationship = request.getParameter("relationship");
			statid = request.getParameter("status");
			empid = request.getParameter("employee");
			entity.setContact(contact);
			entity.setPersonname(person);
			entity.setRelationship(relationship);
			entity.setStatusid(Integer.valueOf(statid));
			entity.setEmployeeid(Integer.valueOf(empid));
			if(Da.insertEmployeeContact(entity)==1){
				message ="Successfully Insert Employee Emergency Contact!";
				alertStatus = "SUCCESS";
			}else{
				message ="Failed Insert Employee Emergency Contact!";
				alertStatus = "FAILED";
			}
			response.sendRedirect("Redirect?servletpage=EmergencyContact");
			break;
		case "updateContact":
			id = request.getParameter("id");
			contact = request.getParameter("emergencycontact2");
			person = request.getParameter("personname2");
			relationship = request.getParameter("relationship2");
			statid = request.getParameter("status2");
			empid = request.getParameter("employee2");
			entity.setContact(contact);
			entity.setPersonname(person);
			entity.setRelationship(relationship);
			entity.setStatusid(Integer.valueOf(statid));
			entity.setEmployeeid(Integer.valueOf(empid));
			entity.setContactid(Integer.valueOf(id));
			if(Da.updateEmployeeContact(entity)==1){
				message ="Successfully Update Employee Emergency Contact!";
				alertStatus = "SUCCESS";
			}else{
				message ="Failed Update Employee Emergency Contact!";
				alertStatus = "FAILED";
			}
			response.sendRedirect("Redirect?servletpage=EmergencyContact");
			break;
		case "editForm":
			ArrayList<EmployeeEmergencyContactEntity> contlist;
			String cont = request.getParameter("contid");
			int contid = Integer.valueOf(cont);
			contlist = Da.getEmployeeContactById(contid);
			String jsons = new Gson().toJson(contlist);
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
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<StatusEntity> statuslist=null;
		ArrayList<EmployeeEmergencyContactEntity>emerlist = null;
		ArrayList<EmployeeInformationEntity>emp =null;
		emp = Da.getEmployee();
		statuslist = Status.getStatus();
		emerlist = Da.getEmployeeContactList();
			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("emerlist", emerlist);
			request.setAttribute("empList", emp);
			request.setAttribute("statList", statuslist);
			rd = request.getRequestDispatcher("S-EmployeeEmergencyContact.jsp");
			rd.include(request, response);
		System.out.print("Empty list");
	}
}
