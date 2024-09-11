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

import com.TravelDa.DepartmentDa;
import com.TravelDa.EmployeeDa;
import com.TravelDa.PositionDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.DepartmentEntity;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.PositionEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;
import com.HelperClasses.Helper;
/**
 * Servlet implementation class Employee
 */
@WebServlet("/EmployeeInformation")
public class EmployeeInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String form;
    private EmployeeDa data;
    private PositionDa Position;
    private DepartmentDa Department;
    private StatusDa Status;
    private ArrayList<EmployeeInformationEntity>Employeeist;
    private ArrayList<StatusEntity>Statuslist;
    private ArrayList<PositionEntity>Positionlist;
    private ArrayList<DepartmentEntity>Departmentlist;
    private EmployeeInformationEntity entity;
    Helper Helper;
    private RequestDispatcher rd;
    private String alertStatus="";
    private String message = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInformation() {
        // TODO Auto-generated constructor stub
        data = new EmployeeDa();
        Position = new PositionDa();
        Department = new DepartmentDa();
        Status = new StatusDa();
        entity = new EmployeeInformationEntity();
        Helper = new Helper();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname, mname, lname, bday, gender, contact, address, email;
		int deptid,position,status, id;
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addEmployee":
			fname = Helper.toString(request.getParameter("firstname"));
			mname = Helper.toString(request.getParameter("middlename"));
			lname = request.getParameter("lastname");
			deptid = Helper.toInt(request.getParameter("department"));
			position = Helper.toInt(request.getParameter("position"));
			bday = request.getParameter("birthdate");
			gender = request.getParameter("gender");
			contact = request.getParameter("contact");
			email = request.getParameter("email");
			address = request.getParameter("address");
			status = Helper.toInt(request.getParameter("status"));
			entity.setFirstname(fname);
			entity.setMiddlename(mname);
			entity.setLastname(lname);
			entity.setDepartmentid(deptid);
			entity.setPositionid(position);
			entity.setBirthdate(bday);
			entity.setGender(gender);
			entity.setContact(contact);
			entity.setEmail(email);
			entity.setAddress(address);
			entity.setStatusid(status);
			if(data.insertEmployeeInformation(entity)==1){
				message ="Successfully Insert Employee Information!";
				alertStatus = "SUCCESS";
			}
			else{
				message ="Failed Insert Employee Information!";
				alertStatus = "FAILED";
			}
			response.sendRedirect("Redirect?servletpage=EmployeeInformation&alertStatus="+alertStatus+"&message="+message);
			//System.out.print();
			break;
		case "updateEmployee":
			id = Helper.toInt(request.getParameter("employeeid"));
			fname = Helper.toString(request.getParameter("firstname2"));
			mname = Helper.toString(request.getParameter("middlename2"));
			lname = request.getParameter("lastname2");
			deptid = Helper.toInt(request.getParameter("department2"));
			position = Helper.toInt(request.getParameter("position2"));
			bday = request.getParameter("birthdate2");
			gender = request.getParameter("gender2");
			contact = request.getParameter("contact2");
			email = request.getParameter("email2");
			address = request.getParameter("address2");
			status = Helper.toInt(request.getParameter("status2"));
			
			entity.setFirstname(fname);
			entity.setMiddlename(mname);
			entity.setLastname(lname);
			entity.setDepartmentid(deptid);
			entity.setPositionid(position);
			entity.setBirthdate(bday);
			entity.setGender(gender);
			entity.setContact(contact);
			entity.setEmail(email);
			entity.setAddress(address);
			entity.setStatusid(status);
			entity.setEmployeeid(id);
			if(data.updateEmployeeInformation(entity)==1){
				message ="Successfully Update Employee Information!";
				alertStatus = "SUCCESS";
			}
			else{
				message ="Failed Update Employee Information!";
				alertStatus = "FAILED";
			}
			response.sendRedirect("Redirect?servletpage=EmployeeInformation&alertStatus="+alertStatus+"&message="+message);
			//System.out.print(entity.getEmployeeid());
			break;
		case "editForm":
			 data = new EmployeeDa();
			ArrayList<EmployeeInformationEntity> empbyid;
			int myid = Helper.toInt(request.getParameter("empid"));
			empbyid = data.getAllEmployeeInformationById(myid);
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
		Statuslist = Status.getStatus();
		Positionlist = Position.getPosition();
		Departmentlist = Department.getDepartment();
		Employeeist = data.getAllEmployeeInformation();

			request.setAttribute("jspstatlist", Statuslist);
			request.setAttribute("jspdeptlist", Departmentlist);
			request.setAttribute("jspemplist", Employeeist);
			request.setAttribute("jsppostlist", Positionlist);
			rd = request.getRequestDispatcher("S-EmployeeInformation.jsp");
			rd.include(request, response);

	}

}
