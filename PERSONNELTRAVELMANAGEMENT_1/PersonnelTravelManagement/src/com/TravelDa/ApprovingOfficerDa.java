package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.ApprovingOfficerEntity;

public class ApprovingOfficerDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private int status;
	private  String ApprovingOfficer = "{CALL sp_r_approvingofficer(?,?)}";
	private  String SelectAll = "{CALL sp_approvingofficer_read(?,?,?,?,?,?,?)}";
	private  String SelectAllById = "{CALL sp_approvingofficer_select_id(?,?,?,?,?,?,?)}";
	private  String InsertAppOff = "{CALL sp_approvingofficer_create(?,?,?)}";
	private  String UpdateAppOff = "{CALL sp_approvingofficer_update(?,?,?,?)}";
	private  String ApprovingOfficerId = "{CALL sp_approvingofficer_id(?,?)}";
	
	public ApprovingOfficerDa() {
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
}

	
	public int insertApprovingOfficer(ApprovingOfficerEntity appoff)
	{
		try {
			cs = conn.prepareCall(InsertAppOff);
			cs.setString(1, appoff.getDescription());
			cs.setInt(2, appoff.getEmployeeid());
			cs.setInt(3, appoff.getStatusid());
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
	public int updateApprovingOfficer(ApprovingOfficerEntity appoff)
	{
		try {
			cs = conn.prepareCall(UpdateAppOff);
			cs.setInt(4, appoff.getOfficerid());
			cs.setString(1, appoff.getDescription());
			cs.setInt(2, appoff.getEmployeeid());
			cs.setInt(3, appoff.getStatusid());
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


	public ArrayList<ApprovingOfficerEntity> getAllApprovingOfficerById(int id){
		ArrayList<ApprovingOfficerEntity> list = null;
		try {
			list = new ArrayList<ApprovingOfficerEntity>(); 
			cs = conn.prepareCall(SelectAllById);
			cs.setInt(1, id);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ApprovingOfficerEntity appoff = new ApprovingOfficerEntity();
				appoff.setOfficerid(rs.getInt(1));
				appoff.setEmployee(rs.getString(2));
				appoff.setDescription(rs.getString(3));
				appoff.setStatus(rs.getString(4));
				appoff.setEmployeeid(rs.getInt(5));
				appoff.setStatusid(rs.getInt(6));
				list.add(appoff);
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
	
	
	public ArrayList<ApprovingOfficerEntity> getAllApprovingOfficer(){
		ArrayList<ApprovingOfficerEntity> list = null;
		try {
			list = new ArrayList<ApprovingOfficerEntity>(); 
			cs = conn.prepareCall(SelectAll);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ApprovingOfficerEntity appoff = new ApprovingOfficerEntity();
				appoff.setOfficerid(rs.getInt(1));
				appoff.setEmployee(rs.getString(2));
				appoff.setDescription(rs.getString(3));
				appoff.setDepartment(rs.getString(4));
				appoff.setStatus(rs.getString(5));
				appoff.setEmployeeid(rs.getInt(6));
				appoff.setStatusid(rs.getInt(7));
				list.add(appoff);
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

	public ArrayList<ApprovingOfficerEntity> getApprovingOfficer(){
		ArrayList<ApprovingOfficerEntity> list = null;
		try {
			
			list = new ArrayList<ApprovingOfficerEntity>(); 
			cs = conn.prepareCall(ApprovingOfficer);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
			ApprovingOfficerEntity entity = new ApprovingOfficerEntity();
			entity.setOfficerid(rs.getInt(1));
			entity.setEmployee(rs.getString(2));
				list.add(entity);
			}
			
			//return list;
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
	
	public int getApprovingOfficerId(int empid){
		int id = 0;
		try { 
			cs = conn.prepareCall(ApprovingOfficerId);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
               id = rs.getInt(1);
			}
			
			//return list;
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
		return id;
	}
	
}
