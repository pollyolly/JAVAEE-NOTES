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
import com.TravelDa.UserManagementDa;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.StatusEntity;
import com.TravelEntity.UserManagementEntity;
import com.google.gson.*;
import com.HelperClasses.Helper;

@WebServlet("/UserManagement")
public class UserManagement extends HttpServlet {
	private static final long serialVersionUID = 11;
	private UserManagementDa accDa;
	private UserManagementEntity accEnt;
	private String user, pass, roleid, empid, statid, forms = "", myaccid;
	private ArrayList<UserManagementEntity> acc, emp, role, stat, accid;
	private RequestDispatcher rd;
	private boolean status;
	private String myeditid;
	private EmployeeDa Employee;
	private StatusDa Status;
	private String alertStatus="";
    private String message = "";
    
	public UserManagement() {
		super();
		accEnt = new UserManagementEntity();
		accDa = new UserManagementDa();
		Employee = new EmployeeDa();
		Status = new StatusDa();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		forms = request.getParameter("forms");
		switch (forms) {
		case "addAccount":
			user = request.getParameter("username");
			pass = request.getParameter("password");
			roleid = request.getParameter("role");
			empid = request.getParameter("employee");
			statid = request.getParameter("status");
			myaccid = request.getParameter("accountid");
			if (user.trim().length() > 0 && pass.trim().length() > 0 && roleid.trim().length() > 0
					&& empid.trim().length() > 0 && statid.trim().length() > 0) {
				accEnt.setUsername(user);
				accEnt.setPassword(pass);
				accEnt.setRoleid(Integer.valueOf(roleid));
				accEnt.setEmployeeid(Integer.valueOf(empid));
				accEnt.setStatusid(Integer.valueOf(statid));
				if(accDa.insertAccount(accEnt)==1){
					message ="Successfully Insert UserManagement!";
					alertStatus = "SUCCESS";
				}
				else{
					message ="Failed Insert UserManagement!";
					alertStatus = "FAILED";
				}
				sendRedirect(response);
			}
			break;
		case "editAccount":
			user = request.getParameter("username2");
			pass = request.getParameter("password2");
			roleid = request.getParameter("role2");
			empid = request.getParameter("employee2");
			statid = request.getParameter("status2");
			myaccid = request.getParameter("accountid2");
			if (user.trim().length() > 0 && pass.trim().length() > 0 && roleid.trim().length() > 0
					&& empid.trim().length() > 0 && statid.trim().length() > 0) {
				accEnt.setUsername(user);
				accEnt.setPassword(pass);
				accEnt.setRoleid(Integer.valueOf(roleid));
				accEnt.setEmployeeid(Integer.valueOf(empid));
				accEnt.setStatusid(Integer.valueOf(statid));
				accEnt.setAccountid(Integer.valueOf(myaccid));
				if(accDa.updateAccount(accEnt)==1){
					message ="Successfully Update UserManagement!";
					alertStatus = "SUCCESS";
				}
				else{
					message ="Failed Update UserManagement!";
					alertStatus = "FAILED";
				}
				sendRedirect(response);
			}
			break;
		case "editForm": //maylaman
			accDa = new UserManagementDa();
			myeditid = request.getParameter("accid");
			int myid = Integer.valueOf(myeditid); //maylaman
			accid = accDa.getSelectAccountId(myid);
			String jsons = new Gson().toJson(accid);
			if(jsons.trim().length()>0){
			out.print(jsons);
			out.flush();
			out.close();
			}
			else{
				System.out.print("POTA NAMAN!!!");
			}
			break;
		}
		list(request, response);
	}
	
	protected void sendRedirect(HttpServletResponse response) throws IOException{
		response.sendRedirect("Redirect?servletpage=UserManagement&alertStatus="+alertStatus+"&message="+message);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list(request, response);
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		acc = accDa.getAllAccount();
		ArrayList<EmployeeInformationEntity>emp = Employee.getEmployee();
		role = accDa.getRoleList();
		ArrayList<StatusEntity>stat = Status.getStatus();
			request.setAttribute("accList", acc);
			request.setAttribute("empList", emp);
			request.setAttribute("roleList", role);
			request.setAttribute("statList", stat);
			rd = request.getRequestDispatcher("C-Usermanagement.jsp");
			rd.include(request, response);

	}

}
