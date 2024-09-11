package com.Administrator;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Connector.DbConnect;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Servlet implementation class _ReportTravelPlan
 */
@WebServlet("/_ReportTravelPlan")
public class _ReportTravelPlan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _ReportTravelPlan() {
     	try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tono = request.getParameter("tono");
		String tpid = request.getParameter("tpid");
		String reportFile = getServletContext().getRealPath("_ReportTravelPlan.jrxml");
		InputStream file  = new FileInputStream(new File(reportFile));
		try {
			String targetFileName=reportFile.replace(".jrxml", ".pdf");
			JasperReport jasperReport = JasperCompileManager.compileReport(file);
			Map parameter = new HashMap();
			parameter.put("tono",tono);
			parameter.put("tpid",tpid);
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
