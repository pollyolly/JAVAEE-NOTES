package com.Administrator;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
//import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import com.TravelDa.StatusDa;
import com.TravelDa.SupportDocumentDa;
import com.TravelDa.TravelOrderDa;
import com.TravelEntity.StatusEntity;
import com.TravelEntity.SupportDocumentEntity;
import com.TravelEntity.TravelOrderEntity;

/**
 * Servlet implementation class SupportDocument
 */
@WebServlet("/SupportDocument")
public class SupportDocument extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
    private String  filePath = "C:"+File.separator+"uploads";
    private int maxFileSize = 1024 * 1024;
    private int maxMemSize = 1024 * 1024;
    private File file ;
    private String desc, statusid, tono;
    private int id;
    private TravelOrderDa ToDa;
    private StatusDa Status;
    private SupportDocumentDa Da;
    private SupportDocumentEntity entity;
    private ArrayList<TravelOrderEntity> tonolist;
    private ArrayList<StatusEntity> statuslist;
    private String alert;
    private String alertStatus="";
    private String message = "";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportDocument() {
        // TODO Auto-generated constructor stub
    	ToDa = new TravelOrderDa();
    	Da = new SupportDocumentDa();
    	entity = new SupportDocumentEntity();
    	//Status = new StatusDa();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	if(isMultipart){
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize);
		factory.setRepository(new File("C:/Temp"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax( maxFileSize );
		
		try {
			List fileItems = upload.parseRequest(request);
			Iterator itr = fileItems.iterator();
			while(itr.hasNext())
			{
				FileItem fi = (FileItem) itr.next();
				if (fi.isFormField())
		         {
					String field = fi.getFieldName();
					if(field.equals("tono")){
						 tono = fi.getString();
						entity.setTono(tono);
					}
					if(field.equals("description")){
							 desc = fi.getString();
							 entity.setDescription(desc);
						}
					if(field.equals("status")){
						  	statusid = fi.getString();
							entity.setStatusid(Integer.valueOf(statusid));
						}
			} else{
				//String fieldName = fi.getFieldName();
				String fileName = null;//, contentType = null;
				//boolean isInMemory = false;
				long sizeInBytes = 0;
		            fileName = fi.getName();
		        //    contentType = fi.getContentType();
		           // isInMemory = fi.isInMemory();
		            sizeInBytes = fi.getSize();
		           
		           if(sizeInBytes > 0){
			            file = new File(filePath+File.separator+fileName);
			            boolean fileExists = file.isFile();
			            if(fileExists == false){
				            file.createNewFile();
						 	file.setExecutable(true);
						  	file.setReadable(true);
						  	file.setWritable(true);
						  	file.mkdir();
						  	fi.write(file);
						  entity.setFile(fileName);
						 
			            }else{message ="File already exists!";}	
			            
			           
		           }
		           		
		           else{
		        	   message ="Empty File!";
		           } 
			}
				}
			
			if(Da.insertSupportDocument(entity) == 1){
				message ="Successfully Insert Support Document!";
				alertStatus = "SUCCESS";
			}
			else{
				message ="Failed Insert Support Document!";
				alertStatus = "FAILED";
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Redirect?servletpage=SupportDocument");
	}
	
	doGet(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//statuslist = Status.getStatus();
		tonolist = ToDa.getTOno();
		ArrayList<SupportDocumentEntity> doclist = Da.getSupportDocument();
		request.setAttribute("message", message);
		request.setAttribute("alertStatus", alertStatus);
		//request.setAttribute("statlist", statuslist);
		request.setAttribute("tolist", tonolist);
		request.setAttribute("doclist", doclist);
		rd = request.getRequestDispatcher("T-Supportdocument.jsp");
		rd.include(request, response);
	}
}
