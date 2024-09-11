package com.Administrator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.TravelDa.TravelOrderDa;
import com.TravelEntity.TravelOrderEntity;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

/**
 * Servlet implementation class Import
 */
@WebServlet("/Import")
@MultipartConfig()
public class Import extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Part file;
    private ArrayList<TravelOrderEntity> tolist = new ArrayList<TravelOrderEntity>();
    private String line="";
    private TravelOrderDa DA;
    private TravelOrderEntity Entity;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Import() {
        // TODO Auto-generated constructor stub
    	//DA = new TravelOrderDa();
    	//Entity = new TravelOrderEntity();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String form = null, formval = null, filename = null;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iter = items.iterator();
			while(iter.hasNext()){
				FileItem item = iter.next();
				if(item.isFormField()){
					form = item.getFieldName();
					formval = item.getString();
					filename = item.getName();
					String File = getServletContext().getRealPath(filename);
					switch(formval){
					case "TravelOrder":
						readTravelOrderCSV(File,response);
						break;
					case "TravelPlan":
						break;
					default:
						break;
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void readTravelOrderCSV(String filename, HttpServletResponse response)  throws ServletException, IOException {
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filename));
			br.readLine();
			while ((line = br.readLine()) != null) {
			    String[] val = line.split(",");
			    TravelOrderEntity entity = new TravelOrderEntity();  
			    // add values from csv to car object  
			    entity.setTodate(val[0]);  
			    entity.setPurpose(val[1]);  
			    entity.setPriorityid(Integer.valueOf(val[2]));
			    entity.setEmployeeid(Integer.valueOf(val[3]));  
			    entity.setStatusid(Integer.valueOf(val[4]));  
			    entity.setOfficerid(Integer.valueOf(val[5]));
			    entity.setDestinationid(Integer.valueOf(val[6]));
			    tolist.add(entity); }
				
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int k = 0; k<tolist.size(); k++){
			Entity = new TravelOrderEntity();
			DA = new TravelOrderDa();
			TravelOrderEntity list = tolist.get(k);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			@SuppressWarnings("deprecation")
			Date date = new Date(list.getTodate());
			Entity.setTodate(dateFormat.format(date));
			Entity.setPurpose(list.getPurpose());
			Entity.setPriorityid(list.getPriorityid());
			Entity.setEmployeeid(list.getEmployeeid());
			Entity.setStatusid(list.getStatusid());
			Entity.setOfficerid(list.getOfficerid());
			Entity.setDestinationid(list.getDestinationid());
			DA.importTravelOrder(Entity);
		}
		response.sendRedirect("Redirect?servletpage=TravelOrder");
	}
	protected void readTravelPlan(HttpServletResponse response)  throws ServletException, IOException {
		
	}
	protected void readTravelExpense(HttpServletResponse response)  throws ServletException, IOException {
		
	}
}
