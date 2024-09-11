package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.AuthenticationEntity;
import com.TravelEntity.UserManagementEntity;

public class AuthenticationDa {
	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private String Authenticate = "{CALL sp_authentication(?,?,?,?,?,?,?)}";
	public AuthenticationDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<AuthenticationEntity> getAuthentication(String user, String pass){
		ArrayList<AuthenticationEntity> list = null;
		try {
			list = new ArrayList<AuthenticationEntity>(); 
			cs = conn.prepareCall(Authenticate);
			cs.setString(1, user);//Username
			cs.setString(2, pass);//Password
			cs.registerOutParameter(3, Types.VARCHAR);//User
			cs.registerOutParameter(4, Types.VARCHAR);//Pass
			cs.registerOutParameter(5, Types.VARCHAR);//Employee
			cs.registerOutParameter(6, Types.VARCHAR);//role
			cs.registerOutParameter(7, Types.INTEGER);//EmpId
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				AuthenticationEntity entity = new AuthenticationEntity();
				entity.setUser(rs.getString(1));
				entity.setPass(rs.getString(2));
				entity.setEmployee(rs.getString(3));
				entity.setRole(rs.getString(4));
				entity.setEmployeeid(rs.getInt(5));
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

}
