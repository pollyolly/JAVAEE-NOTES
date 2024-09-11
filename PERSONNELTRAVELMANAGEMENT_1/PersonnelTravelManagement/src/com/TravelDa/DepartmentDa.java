package com.TravelDa;

import com.Connector.DbConnect;
import com.TravelEntity.DepartmentEntity;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;

public class DepartmentDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private  String SelectDepartment = "{CALL sp_department_read(?,?,?,?,?)}";
	private  String SelectDepartmentId = "{CALL sp_department_select_id(?,?,?,?,?,?)}";
	private  String InsertDepartment = "{CALL sp_department_create(?,?,?)}";
	private  String UpdateDepartment = "{CALL sp_department_update(?,?,?,?)}";
	private  String Department = "{CALL sp_r_department(?,?)}";
	public DepartmentDa() {
			try {
				conn = DbConnect.getConnection();
				//myAcc = new AccountEntity();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	public boolean insertDepartment(DepartmentEntity dept){
		try {
			cs = conn.prepareCall(InsertDepartment);
			cs.setString(1, dept.getDepartment());
			cs.setString(2, dept.getDescription());
			cs.setInt(3, dept.getStatusid());
			status = cs.execute();
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
	
	public boolean updateDepartment(DepartmentEntity dept){
		try {
			cs = conn.prepareCall(UpdateDepartment);
			cs.setInt(4, dept.getDepartmentid());
			cs.setString(1, dept.getDepartment());
			cs.setString(2, dept.getDescription());
			cs.setInt(3, dept.getStatusid());
			status = cs.execute();
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
	
	
	public ArrayList<DepartmentEntity> getAllDepartment(){
		ArrayList<DepartmentEntity> list = null;
		try {
			list = new ArrayList<DepartmentEntity>(); 
			cs = conn.prepareCall(SelectDepartment);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DepartmentEntity dept = new DepartmentEntity();
				dept.setDepartment(rs.getString(1));
				dept.setDescription(rs.getString(2));
				dept.setStatus(rs.getString(3));
				dept.setDepartmentid(rs.getInt(4));
				dept.setStatusid(rs.getInt(5));
				list.add(dept);
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
	
	public ArrayList<DepartmentEntity> getAllDepartmentId(int id){
		ArrayList<DepartmentEntity> list = null;
		try {
			list = new ArrayList<DepartmentEntity>(); 
			cs = conn.prepareCall(SelectDepartmentId);
			cs.setInt(6, id);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DepartmentEntity dept = new DepartmentEntity();
				dept.setDepartment(rs.getString(1));
				dept.setDescription(rs.getString(2));
				dept.setStatus(rs.getString(3));
				dept.setDepartmentid(rs.getInt(4));
				dept.setStatusid(rs.getInt(5));
				list.add(dept);
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
	public ArrayList<DepartmentEntity> getDepartment(){
		ArrayList<DepartmentEntity> list = null;
		try {
			list = new ArrayList<DepartmentEntity>(); 
			cs = conn.prepareCall(Department);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DepartmentEntity dept = new DepartmentEntity();
				dept.setDepartmentid(rs.getInt(1));
				dept.setDepartment(rs.getString(2));
				list.add(dept);
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
