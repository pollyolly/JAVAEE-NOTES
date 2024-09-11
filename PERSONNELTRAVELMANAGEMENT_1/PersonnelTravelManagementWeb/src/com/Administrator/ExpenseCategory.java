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

import com.TravelEntity.DepartmentEntity;
import com.TravelEntity.ExpenseCategoryEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;
import com.TravelDa.DepartmentDa;
import com.TravelDa.ExpenseCategoryDa;
import com.TravelDa.StatusDa;
import com.HelperClasses.Helper;
/**
 * Servlet implementation class ExpenseCategory
 */
@WebServlet("/ExpenseCategory")
public class ExpenseCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ExpenseCategoryEntity entity;
	private ExpenseCategoryDa data;
	private RequestDispatcher rd;
	private Helper Helper;
	private String form;
	private ArrayList<ExpenseCategoryEntity> Alllist,AlllistById;
	private StatusDa Status;
	private DepartmentDa Department;
    public ExpenseCategory() {
        entity = new ExpenseCategoryEntity();
        data = new ExpenseCategoryDa();
        Helper = new Helper();
        Status = new StatusDa();
        Department = new DepartmentDa();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addExpenseCategory":
			String nym = request.getParameter("name");
			double amnt = Helper.toDouble(request.getParameter("rate"));
			int statid = Helper.toInt(request.getParameter("status"));
			int deptid = Helper.toInt(request.getParameter("department"));
			if(nym.trim().length() > 0 && amnt > 0 && statid > 0 && deptid > 0){
				entity.setName(nym);
				entity.setDepartmentid(deptid);
				entity.setRate(amnt);
				entity.setStatusid(statid);
				data.insertExpenseCategory(entity);
				response.sendRedirect("Redirect?servletpage=ExpenseCategory");
			}else{System.out.print("Empty Add");}
			break;
		case "updateExpenseCategory":
			int id = Helper.toInt(request.getParameter("expensecatid"));
			String nym2 = Helper.toString(request.getParameter("name2"));
			double amnt2 = Helper.toDouble(request.getParameter("rate2"));
			int statid2 = Helper.toInt(request.getParameter("status2"));
			int deptid2 = Helper.toInt(request.getParameter("department2"));
			if(nym2.trim().length() > 0 && amnt2 > 0 && statid2 > 0 && deptid2 > 0){
				entity.setName(nym2);
				entity.setDepartmentid(deptid2);
				entity.setRate(amnt2);
				entity.setStatusid(statid2);
				entity.setExpensecatid(id);
				data.updateExpenseCategory(entity);
				response.sendRedirect("Redirect?servletpage=ExpenseCategory");
			}else{System.out.print("Empty Update");}
			break;
		case "editForm":
			data = new ExpenseCategoryDa();
			int editid = Helper.toInt(request.getParameter("expenseid"));
			AlllistById = data.getAllExpenseCategoryById(editid);
			String jsons = new Gson().toJson(AlllistById);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
			} else {
				System.out.print("Empty jsonss");
			}
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
		Alllist =  data.getAllExpenseCategory();
		ArrayList<DepartmentEntity>Deptlist = Department.getAllDepartment();
		ArrayList<StatusEntity>Statlist = Status.getStatus();

			request.setAttribute("jspAlllist", Alllist);
			request.setAttribute("jspStatlist", Statlist);
			request.setAttribute("jspDeptlist", Deptlist);
			rd = request.getRequestDispatcher("C-Expensecategory.jsp");
			rd.include(request, response);

	}
}
