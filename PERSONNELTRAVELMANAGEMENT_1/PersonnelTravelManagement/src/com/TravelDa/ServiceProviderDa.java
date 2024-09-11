package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.DepartmentEntity;
import com.TravelEntity.ServiceProviderEntity;

public class ServiceProviderDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;             
	private boolean status = false;
	private  String SelectById = "{CALL sp_serviceprovider_select_id(?,?,?,?,?,?,?,?,?)}";
	private  String SelectAll = "{CALL sp_serviceprovider_read(?,?,?,?,?,?,?,?)}";
	private  String Insert = "{CALL sp_serviceprovider_create(?,?,?,?,?,?)}";
	private  String Update = "{CALL sp_serviceprovider_update(?,?,?,?,?,?,?)}";
	private  String Select = "{CALL sp_r_serviceprovider(?,?)}";
	
	public ServiceProviderDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public boolean insertServiceProvider(ServiceProviderEntity entity){
		try {
			cs = conn.prepareCall(Insert);
			cs.setString(1, entity.getCompany());
			cs.setString(2, entity.getContact());
			cs.setString(3, entity.getWebsite());
			cs.setString(4, entity.getEmail());
			cs.setString(5, entity.getAddress());
			cs.setInt(6, entity.getStatusid());
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
	public boolean updateServiceProvider(ServiceProviderEntity entity){
		try {
			cs = conn.prepareCall(Update);
			cs.setString(1, entity.getCompany());
			cs.setString(2, entity.getContact());
			cs.setString(3, entity.getWebsite());
			cs.setString(4, entity.getEmail());
			cs.setString(5, entity.getAddress());
			cs.setInt(6, entity.getStatusid());
			cs.setInt(7, entity.getId());
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
	
	public ArrayList<ServiceProviderEntity> getServiceProvider(){
		ArrayList<ServiceProviderEntity> list = null;
		try {
			list = new ArrayList<ServiceProviderEntity>(); 
			cs = conn.prepareCall(SelectAll);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServiceProviderEntity entity = new ServiceProviderEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
				entity.setContact(rs.getString(3));
				entity.setWebsite(rs.getString(4));
				entity.setEmail(rs.getString(5));
				entity.setAddress(rs.getString(6));
				entity.setStatus(rs.getString(7));
				entity.setStatusid(rs.getInt(8));
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
	public ArrayList<ServiceProviderEntity> getServiceProviderById(int id){
		ArrayList<ServiceProviderEntity> list = null;
		try {
			list = new ArrayList<ServiceProviderEntity>(); 
			cs = conn.prepareCall(SelectById);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.INTEGER);
			cs.setInt(9, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServiceProviderEntity entity = new ServiceProviderEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
				entity.setContact(rs.getString(3));
				entity.setWebsite(rs.getString(4));
				entity.setEmail(rs.getString(5));
				entity.setAddress(rs.getString(6));
				entity.setStatus(rs.getString(7));
				entity.setStatusid(rs.getInt(8));
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
	
	public ArrayList<ServiceProviderEntity> getServiceProviderList(){
		ArrayList<ServiceProviderEntity> list = null;
		try {
			list = new ArrayList<ServiceProviderEntity>(); 
			cs = conn.prepareCall(Select);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServiceProviderEntity entity = new ServiceProviderEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
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
