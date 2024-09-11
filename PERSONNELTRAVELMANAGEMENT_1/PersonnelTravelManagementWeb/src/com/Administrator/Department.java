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
import com.TravelDa.StatusDa;
import com.TravelEntity.DepartmentEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.*;
import com.HelperClasses.Helper;
/**
 * Servlet implementation class Department
 */
@WebServlet("/Department")
public class Department extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, desc, stat, form, myeditid, deptid;
	private DepartmentEntity deptent;
	private DepartmentDa deptda;
	private ArrayList<DepartmentEntity> deptlist, statlist, deptidlist;
	private RequestDispatcher rd;
	private StatusDa Status;
	
	public Department() {
		super();
		deptda = new DepartmentDa();
		deptent = new DepartmentEntity();
		Status = new StatusDa();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form) {
		case "addDepartment":
			name = request.getParameter("name");
			desc = request.getParameter("description");
			stat = request.getParameter("status");
			int statid = Integer.valueOf(stat);
			if (name.trim().length() > 0 && desc.trim().length() > 0 && statid > 0) {
				deptent.setDepartment(name);
				deptent.setDescription(desc);
				deptent.setStatusid(statid);
				deptda.insertDepartment(deptent);
				response.sendRedirect("Redirect?servletpage=Department");
			}
			break;
		case "editDepartment":
			name = request.getParameter("name2");
			desc = request.getParameter("description2");
			stat = request.getParameter("status2");
			deptid = request.getParameter("departmentid2");
			if (name.trim().length() > 0 && desc.trim().length() > 0 && stat.trim().length() > 0 && deptid.trim().length() > 0) {
				deptent.setDepartmentid(Integer.valueOf(deptid));
				deptent.setDepartment(name);
				deptent.setDescription(desc);
				deptent.setStatusid(Integer.valueOf(stat));
				deptda.updateDepartment(deptent);
				response.sendRedirect("Redirect?servletpage=Department");
			}
			break;
		case "editForm":
			deptda = new DepartmentDa();
			myeditid = request.getParameter("deptid");
			int myid = Integer.valueOf(myeditid);
			deptidlist = deptda.getAllDepartmentId(myid);
			String jsons = new Gson().toJson(deptidlist);
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
		deptlist = deptda.getAllDepartment();
		ArrayList<StatusEntity>statlist = Status.getStatus();

			request.setAttribute("deptlist", deptlist);
			request.setAttribute("statlist", statlist);
			rd = request.getRequestDispatcher("S-Department.jsp");
			rd.include(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		list(request, response);
	}
}
