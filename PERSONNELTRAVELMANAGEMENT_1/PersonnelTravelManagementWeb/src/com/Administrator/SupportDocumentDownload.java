package com.Administrator;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TravelDa.StatusDa;
import com.TravelDa.SupportDocumentDa;
import com.TravelDa.TravelOrderDa;
import com.TravelEntity.StatusEntity;
import com.TravelEntity.SupportDocumentEntity;
import com.TravelEntity.TravelOrderEntity;

/**
 * Servlet implementation class SupportDocumentDownload
 */
@WebServlet("/SupportDocumentDownload")
public class SupportDocumentDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private File file ;
    private String desc, status, tono;
    private int id;
    private TravelOrderDa ToDa;
    private StatusDa Status;
    private SupportDocumentDa Da;
    private SupportDocumentEntity entity;
    private ArrayList<TravelOrderEntity> tonolist;
    private ArrayList<StatusEntity> statuslist;
    private RequestDispatcher rd;
    private String  filePath = "C:"+File.separator+"uploads";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportDocumentDownload() {
    	ToDa = new TravelOrderDa();
    	Da = new SupportDocumentDa();
    	entity = new SupportDocumentEntity();
    	Status = new StatusDa();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ServletOutputStream op = response.getOutputStream();
		String file = request.getParameter("file");
		int length = 0;
		File myfile = new File(filePath+File.separator+file);
	//	if(myfile.getName() == "file"){
			 ServletContext context  = getServletConfig().getServletContext();
			 String   mimetype = context.getMimeType(file);
			 response.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
			 response.setContentLength( (int)myfile.length() );
			 response.setHeader( "Content-Disposition", "attachment; filename=\""+file);
			 byte[] bbuf = new byte[1024*1024];
		        DataInputStream in = new DataInputStream(new FileInputStream(myfile));
		       // ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
		        while ((in != null) && ((length = in.read(bbuf)) != -1))
		        {
		        	 response.getOutputStream().write(bbuf,0,length);
		        	 //response.getOutputStream().write(byteArray.toByteArray());
		        }
		        in.close();
		        
		        response.getOutputStream().flush();
				response.getOutputStream().close();
	//	}
		
		statuslist = Status.getStatus();
		tonolist = ToDa.getTOno();
		ArrayList<SupportDocumentEntity> doclist = Da.getSupportDocument();
		request.setAttribute("statlist", statuslist);
		request.setAttribute("tolist", tonolist);
		request.setAttribute("doclist", doclist);
		//rd = request.getRequestDispatcher("T-Supportdocument.jsp");
		//rd.include(request, response);
		//response.sendRedirect("Redirect?servletpage=SupportDocument");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
