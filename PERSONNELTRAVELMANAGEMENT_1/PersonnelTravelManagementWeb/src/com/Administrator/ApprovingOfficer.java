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
import com.TravelDa.ApprovingOfficerDa;
import com.TravelEntity.ApprovingOfficerEntity;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.*;

@WebServlet("/ApprovingOfficer")
public class ApprovingOfficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String officerid, descriptions, employeeid, statusid, form, offid;
	private ApprovingOfficerEntity Entity;
	private EmployeeInformationEntity EmployeeInformationEntity;
	private ApprovingOfficerDa Dataaccess;
	private EmployeeDa Employee;
	private ArrayList<ApprovingOfficerEntity> Alllist, Byidlist;
	private ArrayList<StatusEntity> Statuslist;
	private ArrayList<EmployeeInformationEntity> Employeelist;
	private RequestDispatcher rd;
	private StatusDa Status;
	private String alertStatus;
    private String message = "";
	
    public ApprovingOfficer() {
        Entity = new ApprovingOfficerEntity();
        Dataaccess = new ApprovingOfficerDa();
        Employee = new EmployeeDa();
        EmployeeInformationEntity = new EmployeeInformationEntity();
        Status = new StatusDa();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form){
			case "addApprovingOfficer":
				descriptions = request.getParameter("description");
				employeeid = request.getParameter("employee");
				statusid = request.getParameter("status");
				int statid = Integer.valueOf(statusid);
				int empid = Integer.valueOf(employeeid);
				if (descriptions.trim().length() > 0 && empid> 0 && statid > 0) {
					Entity.setDescription(descriptions);
					Entity.setEmployeeid(empid);
					Entity.setStatusid(statid);
					if(Dataaccess.insertApprovingOfficer(Entity)==1){
						message ="Successfully Insert Support Document!";
						alertStatus = "SUCCESS";
					} else{
						message ="Failed Insert Support Document!";
						alertStatus = "FAILED";
					}
					response.sendRedirect("Redirect?servletpage=ApprovingOfficer&alertStatus="+alertStatus+"&message="+message);
				} else { System.out.print("add Approving not working");}
			break;
			case "editApprovingOfficer":
				descriptions = request.getParameter("description2");
				employeeid = request.getParameter("employee2");
				statusid = request.getParameter("status2");
				offid = request.getParameter("officerid");
				int offid2 = Integer.valueOf(offid);
				int statid2 = Integer.valueOf(statusid);
				int empid2 = Integer.valueOf(employeeid);
				if (descriptions.trim().length() > 0 && empid2> 0 && statid2 > 0) {
					Entity.setDescription(descriptions);
					Entity.setEmployeeid(empid2);
					Entity.setStatusid(statid2);
					Entity.setOfficerid(offid2);
					if(Dataaccess.updateApprovingOfficer(Entity)==1){
						message ="Successfully Update Support Document!";
						alertStatus = "SUCCESS";
						
					}else{
						message ="Failed Update Support Document!";
						alertStatus = "FAILED";
					}
					response.sendRedirect("Redirect?servletpage=ApprovingOfficer&alertStatus="+alertStatus+"&message="+message);
				} else { System.out.print("Edit Approving not working");}
			break;
			case "editForm":
				Dataaccess = new ApprovingOfficerDa();
				officerid = request.getParameter("appoffid");
				int offid = Integer.valueOf(officerid);
				Byidlist = Dataaccess.getAllApprovingOfficerById(offid);
				String jsons = new Gson().toJson(Byidlist);
				if (jsons.trim().length() > 0) {
					out.print(jsons);
					out.flush();
					out.close();
				} else {
					System.out.print("Department empty jsonss");
				}
			break;
		}
		list(request, response);
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statuslist = Status.getStatus();
		Employeelist = Employee.getEmployee();
		Alllist = Dataaccess.getAllApprovingOfficer();

			request.setAttribute("message", message);
			request.setAttribute("alertStatus", alertStatus);
			request.setAttribute("employeelist", Employeelist);
			request.setAttribute("statuslist", Statuslist);
			request.setAttribute("alllist", Alllist);
			rd = request.getRequestDispatcher("C-Approvingofficer.jsp");
			rd.include(request, response);

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		list(request, response);
	}
}
