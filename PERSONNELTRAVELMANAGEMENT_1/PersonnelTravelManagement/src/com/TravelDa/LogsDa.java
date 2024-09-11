package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.ApprovingOfficerEntity;
import com.TravelEntity.LogsEntity;

public class LogsDa {
	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private int status;
	private String insertLogs = "{CALL sp_logs_create(?,?,?,?)}";
	private String readLogs = "{CALL sp_logs_read(?,?,?,?)}";
	public LogsDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public int insertLogs(LogsEntity entity)
	{
		try {
			cs = conn.prepareCall(insertLogs);
			cs.setString(1, entity.getDates());
			cs.setString(2, entity.getTypes());
			cs.setInt(3, entity.getEmployeeid());
			cs.setString(4, entity.getDescription());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(cs!=null)
				{
				cs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public ArrayList<LogsEntity> getLogsList(){
		ArrayList<LogsEntity> list = null;
		try {
			list = new ArrayList<LogsEntity>(); 
			cs = conn.prepareCall(readLogs);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				LogsEntity entity = new LogsEntity();
					entity.setDates(rs.getString(1));
					entity.setTypes(rs.getString(2));
					entity.setEmployee(rs.getString(3));
					entity.setDescription(rs.getString(4));
				list.add(entity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(cs!=null)
				{
				cs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
}
