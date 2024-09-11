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

import com.TravelDa.CompanyPolicyDa;
import com.TravelDa.DepartmentDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.CompanyPolicyEntity;
import com.TravelEntity.DepartmentEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.*;
import com.HelperClasses.Helper;
/**
 * Servlet implementation class CompanyPolicy
 */
@WebServlet("/CompanyPolicy")
public class CompanyPolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyPolicyDa policyda;
	private CompanyPolicyEntity policyentity;
    private ArrayList<CompanyPolicyEntity> alllist, alllistbyid; 
    private RequestDispatcher rd;
    String form, days, recamnt, maxexp, deptid, statid;
    private Helper helper;
    private StatusDa Status;
    private DepartmentDa Department;
    private String alertStatus="";
    private String message = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyPolicy() {
        policyentity = new CompanyPolicyEntity();
        policyda = new CompanyPolicyDa();
        helper = new Helper();
        Status = new StatusDa();
        Department = new DepartmentDa();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addPolicy":
			int day = helper.toInt(request.getParameter("expensedays"));
			double amnt = helper.toDouble(request.getParameter("receiptamount"));
			double maxexp = helper.toDouble(request.getParameter("maxexpense"));
			int statid = helper.toInt(request.getParameter("status"));
			double maxbud = helper.toInt(request.getParameter("maxbudget"));
				policyentity.setExpensedays(day);
				policyentity.setReceiptamount(amnt);
				policyentity.setMaxexpense(maxexp);
				policyentity.setStatusid(statid);
				policyentity.setMaxbudget(maxbud);
				if(policyda.insertCompanyPolicy(policyentity)==1){
					message ="Successfully Insert Company Policy!";
					alertStatus = "SUCCESS";
				}
				else{
					message ="Failed Insert Company Policy!";
					alertStatus = "FAILED";
				}
				response.sendRedirect("Redirect?servletpage=CompanyPolicy&alertStatus="+alertStatus+"&message="+message);
			
			break;
		case "editPolicy":
			int day2 = helper.toInt(request.getParameter("expensedays2"));
			double amnt2 = helper.toDouble(request.getParameter("receiptamount2"));
			double maxexp2 = helper.toDouble(request.getParameter("maxexpense2"));
			int statid2 = helper.toInt(request.getParameter("status2"));
			double maxbud2 = helper.toInt(request.getParameter("maxbudget2"));
			int id = helper.toInt(request.getParameter("policyid"));
				policyentity.setExpensedays(day2);
				policyentity.setReceiptamount(amnt2);
				policyentity.setMaxexpense(maxexp2);
				policyentity.setStatusid(statid2);
				policyentity.setMaxbudget(maxbud2);
				policyentity.setPolicyid(id);
				if(policyda.updateCompanyPolicy(policyentity)==1){
					message ="Successfully Update Company Policy!";
					alertStatus = "SUCCESS";
				}
				else{
					message ="Failed Update Company Policy!";
					alertStatus = "FAILED";
				}
				
				response.sendRedirect("Redirect?servletpage=CompanyPolicy&alertStatus="+alertStatus+"&message="+message);
			break;
		case "editForm":
			policyda = new CompanyPolicyDa();
			int editid = helper.toInt(request.getParameter("policyid"));
			alllistbyid = policyda.getAllCompanyPolicyListById(editid);
			String jsons = new Gson().toJson(alllistbyid);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
			} else {
				System.out.print("Company empty jsonss");
			}
			break;
		}
		list(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		list(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		ArrayList<StatusEntity>statlist = Status.getStatus();
		ArrayList<DepartmentEntity>deptlist = Department.getAllDepartment();
		alllist = policyda.getAllCompanyPolicyList();

			request.setAttribute("statuslist", statlist);
			request.setAttribute("departmentlist", deptlist);
			request.setAttribute("policylist", alllist);
			rd = request.getRequestDispatcher("C-Companypolicy.jsp");
			rd.include(request, response);

	}
}
