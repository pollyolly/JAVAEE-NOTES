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

import com.TravelDa.CardInformationDa;
import com.TravelDa.EmployeeDa;
import com.TravelDa.StatusDa;
import com.TravelEntity.CardInformationEntity;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.StatusEntity;
import com.google.gson.Gson;
import com.HelperClasses.Helper;

/**
 * Servlet implementation class CardInformation
 */
@WebServlet("/CardInformation")
public class CardInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CardInformationEntity entity;
	private CardInformationDa data;
	private Helper helper;
	private StatusDa Status;
	private EmployeeDa Employee;
	private RequestDispatcher rd;
	private String alertStatus="";
    private String message = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardInformation() {
        // TODO Auto-generated constructor stub
        entity = new CardInformationEntity();
        data = new CardInformationDa();
        helper = new Helper();
        Status = new StatusDa();
        Employee = new EmployeeDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ArrayList<CardInformationEntity> byidlist;
		String form, cardno, expdate;
		int ctype, own, emp, stat, myid;
		form = request.getParameter("forms");
		switch(form){
		case "addCardinformation":
		cardno = request.getParameter("cardnumber");
		expdate = request.getParameter("expirydate");
		ctype = helper.toInt(request.getParameter("cardtype"));
		own = helper.toInt(request.getParameter("ownership"));
		emp = helper.toInt(request.getParameter("employee"));
		stat = helper.toInt(request.getParameter("status"));
		entity.setCardnumber(cardno);
		entity.setExpirydate(expdate);
		entity.setCardtypeid(ctype);
		entity.setOwnershipid(own);
		entity.setEmployeeid(emp);
		entity.setStatusid(stat);
		if(data.insertCardInformation(entity)==1){
			message ="Successfully Insert Card Information!";
			alertStatus = "SUCCESS";
		}else{
			message ="Failed Insert Card Information!";
			alertStatus = "FAILED";
		}
		sendRedirect(response);
			break;	
		case "updateCardinformation":
			cardno = request.getParameter("cardnumber2");
			expdate = request.getParameter("expirydate2");
			ctype = helper.toInt(request.getParameter("cardtype2"));
			own = helper.toInt(request.getParameter("ownership2"));
			emp = helper.toInt(request.getParameter("employee2"));
			stat = helper.toInt(request.getParameter("status2"));
			myid = helper.toInt(request.getParameter("cardinfoid"));
			entity.setCardnumber(cardno);
			entity.setExpirydate(expdate);
			entity.setCardtypeid(ctype);
			entity.setOwnershipid(own);
			entity.setEmployeeid(emp);
			entity.setStatusid(stat);
			entity.setCardid(myid);
			if(data.updateCardInformation(entity)==1){
				message ="Successfully Update Card Information!";
				alertStatus = "SUCCESS";
			}else {
				message ="Failed Update Card Information!";
				alertStatus = "FAILED";
			}
			sendRedirect(response);
			break;	
		case "editForm":
			data = new CardInformationDa();
			int editid = helper.toInt(request.getParameter("cardinfoid"));
			byidlist = data.getCardInformationListById(editid);
			String jsons = new Gson().toJson(byidlist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
			} else {
				System.out.print("Empty jsonss");
			}
				break;
		}
		list(request, response);
	}

	protected void sendRedirect(HttpServletResponse response) throws IOException{
		response.sendRedirect("Redirect?servletpage=CardInformation&alertStatus="+alertStatus+"&message="+message);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		list(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<CardInformationEntity> ownlist, cardtyplist, cardinfolist;
		ArrayList<StatusEntity>statlist = Status.getStatus();
		ArrayList<EmployeeInformationEntity> emplist = Employee.getEmployee();
		cardinfolist = data.getAllCardInformationList();
		ownlist = data.getOwnershipList();
		cardtyplist = data.getCardtypeList();

			request.setAttribute("Statlist", statlist);
			request.setAttribute("Emplist", emplist);
			request.setAttribute("Cardinfolist", cardinfolist);
			request.setAttribute("ownlist", ownlist);
			request.setAttribute("cardtyplist", cardtyplist);
			rd = request.getRequestDispatcher("C-Cardinformation.jsp");
			rd.include(request, response);

		
	}
}
