package com.Administrator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.SupportDocumentDa;
import com.TravelEntity.SupportDocumentEntity;

/**
 * Servlet implementation class SupportDocumentUpdate
 */
@WebServlet("/SupportDocumentUpdate")
public class SupportDocumentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SupportDocumentDa Da;
       private SupportDocumentEntity entity;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportDocumentUpdate() {
        // TODO Auto-generated constructor stub
    	Da = new SupportDocumentDa();
    	entity = new SupportDocumentEntity();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("supportid");
		entity.setId(Integer.valueOf(id));
		entity.setStatusid(3);
		Da.updateSupportDocument(entity);
		response.sendRedirect("Redirect?servletpage=SupportDocument");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
