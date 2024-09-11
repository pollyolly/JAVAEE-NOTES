package com.TravelDa;

import com.Connector.DbConnect;
import com.TravelEntity.UserManagementEntity;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;

public class UserManagementDa {
	UserManagementEntity myAcc = null;
	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private int status;
	private  String SelectRole = "{CALL sp_r_role(?,?)}";
	private  String SelectAllAccountId = "{CALL sp_account_select_id(?,?,?,?,?,?,?,?,?,?,?,?)}";
	private  String InsertAccount = "{CALL sp_account_create(?,?,?,?,?)}";
	private  String SelectAllAccount = "{CALL sp_account_read(?,?,?,?,?,?,?,?)}";
	private  String UpdateAccount = "{CALL sp_account_update(?,?,?,?,?,?)}";
	
	public UserManagementDa() {
			try {
				conn = DbConnect.getConnection();
				//myAcc = new AccountEntity();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	public int insertAccount(UserManagementEntity enty){
		
		try {
			cs = conn.prepareCall(InsertAccount);
			cs.setString(1, enty.getUsername());
			cs.setString(2, enty.getPassword());
			cs.setInt(3, enty.getRoleid());
			cs.setInt(4, enty.getEmployeeid());
			cs.setInt(5, enty.getStatusid());
			status = cs.executeUpdate();
			//return status;
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
	
	public int updateAccount(UserManagementEntity enty){
		
		try {
			cs = conn.prepareCall(UpdateAccount);
			cs.setString(1, enty.getUsername());
			cs.setString(2, enty.getPassword());
			cs.setInt(3, enty.getRoleid());
			cs.setInt(4, enty.getEmployeeid());
			cs.setInt(5, enty.getStatusid());
			cs.setInt(6, enty.getAccountid());
			status = cs.executeUpdate();
			//return status;
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
	
	public ArrayList<UserManagementEntity> getAllAccount(){
		ArrayList<UserManagementEntity> list = null;
		try {
			list = new ArrayList<UserManagementEntity>(); 
			cs = conn.prepareCall(SelectAllAccount);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				myAcc = new UserManagementEntity();
				myAcc.setUsername(rs.getString(1));
				myAcc.setPassword(rs.getString(2));
				myAcc.setRole(rs.getString(3));
				myAcc.setEmployee(rs.getString(4));
				myAcc.setDepartment(rs.getString(5));
				myAcc.setStatus(rs.getString(6));
				myAcc.setStatusid(rs.getInt(7));
				myAcc.setAccountid(rs.getInt(8));
				list.add(myAcc);
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
	
	public ArrayList<UserManagementEntity> getSelectAccountId(int id){
		ArrayList<UserManagementEntity> list = null;
		try {
			list = new ArrayList<UserManagementEntity>(); 
			cs = conn.prepareCall(SelectAllAccountId);
			cs.setInt(12, id);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.INTEGER);
			cs.registerOutParameter(9, Types.INTEGER);
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				myAcc = new UserManagementEntity();
				myAcc.setUsername(rs.getString(1));
				myAcc.setPassword(rs.getString(2));
				myAcc.setRole(rs.getString(3));
				myAcc.setEmployee(rs.getString(4));
				myAcc.setDepartment(rs.getString(5));
				myAcc.setStatus(rs.getString(6));
				myAcc.setAccountid(rs.getInt(7));
				myAcc.setRoleid(rs.getInt(8));
				myAcc.setEmployeeid(rs.getInt(9));
				myAcc.setStatusid(rs.getInt(10));
				myAcc.setDepartmentid(rs.getInt(11));
				list.add(myAcc);
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
	
	public ArrayList<UserManagementEntity> getRoleList(){
		ArrayList<UserManagementEntity> list = null;
		try {
			
			list = new ArrayList<UserManagementEntity>(); 
			cs = conn.prepareCall(SelectRole);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				myAcc = new UserManagementEntity();
				myAcc.setRoleid(rs.getInt(1));
				myAcc.setRole(rs.getString(2));
				list.add(myAcc);
				//System.out.print(myAcc.getRoleid() +' '+ myAcc.getRole());
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
}
