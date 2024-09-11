package com.Administrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.HelperClasses.Helper;
import com.TravelDa.EmployeeDa;
import com.TravelDa.TravelOrderDa;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.PositionEntity;
import com.TravelEntity.TravelOrderEntity;
import com.google.gson.Gson;


/**
 * Servlet implementation class TravelOrder
 */
@WebServlet("/TravelOrder")
public class TravelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Helper helper;
	private TravelOrderEntity entity;
	private TravelOrderDa toda;
	private RequestDispatcher rd;
	private EmployeeDa Employee;
	private ArrayList<EmployeeInformationEntity> Employeelist;
	private ArrayList<TravelOrderEntity> TravelOrderlist, Destinationlist, Prioritylist;
	private String Purpose, Destination, Priority, form;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravelOrder() {
        // TODO Auto-generated constructor stub
        entity = new TravelOrderEntity();
        toda = new TravelOrderDa();
        Employee = new EmployeeDa();
        helper = new Helper();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		form = request.getParameter("forms");
		switch(form){
		case "addTO":
			String Personnel[] = request.getParameterValues("employee");
			Purpose = request.getParameter("purpose");
			Destination = request.getParameter("destination");
			Priority = request.getParameter("priority");
			for(int i=0; i<Personnel.length; i++){
			TravelOrderEntity entity = new TravelOrderEntity();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			entity.setTodate(dateFormat.format(date));
			entity.setEmployeeid(Integer.valueOf(Personnel[i]));
			entity.setPurpose(Purpose);
			entity.setDestinationid(Integer.valueOf(Destination));
			entity.setPriorityid(Integer.valueOf(Priority));
			toda.insertTravelOrder(entity);
			}
			response.sendRedirect("Redirect?servletpage=TravelOrder");
			break;
		case "updateTO":
			response.sendRedirect("Redirect?servletpage=TravelOrder");
			break;
		case "popuEmployee":
			toda = new TravelOrderDa();
			ArrayList<TravelOrderEntity> tonolist;
			String mytono = request.getParameter("tono");
			tonolist = toda.getToByTono(mytono);
			String jsons = new Gson().toJson(tonolist);
			if (jsons.trim().length() > 0) {
				out.print(jsons);
				out.flush();
				out.close();
				System.out.print(jsons);
				request.getRequestDispatcher("T-Travelorder.jsp").forward(request, response);
			    return;
			} else {
				System.out.print("Tonolist empty jsonss");
			}
			break;
		default:
			break;
		}
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Destinationlist = toda.getDestination();
		Prioritylist = toda.getPriority();
		TravelOrderlist =  toda.getTravelOrderList();
		Employeelist = Employee.getEmployee();
			request.setAttribute("prioritylist", Prioritylist);
			request.setAttribute("travelorderlist", TravelOrderlist);
			request.setAttribute("employeelist", Employeelist);
			request.setAttribute("destinationlist", Destinationlist);
			rd = request.getRequestDispatcher("T-Travelorder.jsp");
			rd.include(request, response);

	}

}
