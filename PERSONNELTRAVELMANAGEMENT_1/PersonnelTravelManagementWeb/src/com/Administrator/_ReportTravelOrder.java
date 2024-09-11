package com.Administrator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Connector.DbConnect;
import com.HelperClasses.Helper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 * Servlet implementation class _ReportTravelOrder
 */
@WebServlet("/_ReportTravelOrder")
public class _ReportTravelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Helper helper;
	private Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _ReportTravelOrder() {	
    	try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        helper = new Helper();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String toid = request.getParameter("toid");
		int id = helper.toInt(toid);
		
		String reportFile = getServletContext().getRealPath("_ReportTravelOrder.jrxml");
		InputStream file  = new FileInputStream(new File(reportFile));
		//File file  = new File(reportFile);
		try {
			String targetFileName=reportFile.replace(".jrxml", ".pdf");
			JasperDesign jasperDesign = JRXmlLoader.load(file);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			Map parameter = new HashMap();
			parameter.put("toid",id);
			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, conn);
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			if(print != null){
				JasperExportManager.exportReportToPdfStream(print, byteArray);
				response.setContentType("application/pdf");
				//JasperExportManager.exportReportToPdfFile(print);
				response.getOutputStream().write(byteArray.toByteArray());
				response.setHeader("Cache-Control", "max-age=0");
				response.setHeader("Content-Disposition", "attachment; filename=" + targetFileName);
		      }
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
