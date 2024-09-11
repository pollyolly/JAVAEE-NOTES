package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.ApprovingOfficerEntity;
import com.TravelEntity.ServicesEntity;
import com.TravelEntity.TravelPlanEntity;

public class ServicesDa {
	
	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private  String SelectType = "{CALL sp_r_servicetype(?,?)}";
	private  String SelectClass = "{CALL sp_r_serviceclass(?,?)}";
	private  String Select = "{CALL sp_r_services(?,?,?)}";
	private  String SelectServices = "{CALL sp_services_read(?,?,?,?,?,?,?,?)}";
	private  String SelectServicesId = "{CALL sp_services_select_id(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private  String InsertServices = "{CALL sp_services_create(?,?,?,?,?,?,?)}";
	private  String UpdateServices = "{CALL sp_services_update(?,?,?,?,?,?,?,?)}";
	private  String SelectServicesFlight = "{CALL sp_services_flight(?,?,?,?,?,?,?,?)}";
	private  String SelectServicesCar = "{CALL sp_services_car(?,?,?,?,?,?,?,?)}";
	private  String SelectServicesHotel = "{CALL sp_services_hotel(?,?,?,?,?,?,?,?)}";
	public ServicesDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public boolean insertServices(ServicesEntity entity){
		try {
			cs = conn.prepareCall(InsertServices);
			cs.setString(1,entity.getService());
			cs.setString(2, entity.getDescription());
			cs.setInt(3, entity.getServiceproviderid());
			cs.setInt(4, entity.getTypeid());
			cs.setInt(5, entity.getClassid());
			cs.setDouble(6, entity.getAmount());
			cs.setInt(7, entity.getStatusid());
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
	public boolean updateServices(ServicesEntity entity){
		try {
			cs = conn.prepareCall(UpdateServices);
			cs.setString(1,entity.getService());
			cs.setString(2, entity.getDescription());
			cs.setInt(3, entity.getServiceproviderid());
			cs.setInt(4, entity.getTypeid());
			cs.setInt(5, entity.getClassid());
			cs.setDouble(6, entity.getAmount());
			cs.setInt(7, entity.getStatusid());
			cs.setInt(8, entity.getId());
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
	public ArrayList<ServicesEntity> getServices(int spid){
		ArrayList<ServicesEntity> list = null;
		try {
			list = new ArrayList<ServicesEntity>();
			cs = conn.prepareCall(Select);
			cs.setInt(3, spid);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setId(rs.getInt(1));
				entity.setService(rs.getString(2));
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
	
	public ArrayList<ServicesEntity> getServicesList(){
		ArrayList<ServicesEntity> list = null;
		try {
			
			list = new ArrayList<ServicesEntity>(); 
			cs = conn.prepareCall(SelectServices);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
				entity.setService(rs.getString(3));
				entity.setDescription(rs.getString(4));
				entity.setType(rs.getString(5));
				entity.setServiceclass(rs.getString(6));
				entity.setAmount(rs.getDouble(7));
				entity.setStatus(rs.getString(8));
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
	
	public ArrayList<ServicesEntity> getServicesById(int id){
		ArrayList<ServicesEntity> list = null;
		try {
			list = new ArrayList<ServicesEntity>(); 
			cs = conn.prepareCall(SelectServicesId);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.INTEGER);
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.INTEGER);
			cs.registerOutParameter(12, Types.INTEGER);
			cs.setInt(13, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
				entity.setService(rs.getString(3));
				entity.setDescription(rs.getString(4));
				entity.setType(rs.getString(5));
				entity.setServiceclass(rs.getString(6));
				entity.setAmount(rs.getDouble(7));
				entity.setStatus(rs.getString(8));
				entity.setServiceproviderid(rs.getInt(9));
				entity.setTypeid(rs.getInt(10));
				entity.setClassid(rs.getInt(11));
				entity.setStatusid(rs.getInt(12));
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
	public ArrayList<ServicesEntity> getServicesType(){
		ArrayList<ServicesEntity> list = null;
		try {
			list = new ArrayList<ServicesEntity>(); 
			cs = conn.prepareCall(SelectType);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setTypeid(rs.getInt(1));
				entity.setType(rs.getString(2));
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
	public ArrayList<ServicesEntity> getServicesClass(){
		ArrayList<ServicesEntity> list = null;
		try {
			list = new ArrayList<ServicesEntity>(); 
			cs = conn.prepareCall(SelectClass);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setClassid(rs.getInt(1));
				entity.setServiceclass(rs.getString(2));
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
	public ArrayList<ServicesEntity> getServicesFlight(){
		ArrayList<ServicesEntity> list = null;
		try {
			
			list = new ArrayList<ServicesEntity>(); 
			cs = conn.prepareCall(SelectServicesFlight);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
				entity.setService(rs.getString(3));
				entity.setDescription(rs.getString(4));
				entity.setType(rs.getString(5));
				entity.setServiceclass(rs.getString(6));
				entity.setAmount(rs.getDouble(7));
				entity.setStatus(rs.getString(8));
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
	public ArrayList<ServicesEntity> getServicesHotel(){
		ArrayList<ServicesEntity> list = null;
		try {
			
			list = new ArrayList<ServicesEntity>(); 
			cs = conn.prepareCall(SelectServicesHotel);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
				entity.setService(rs.getString(3));
				entity.setDescription(rs.getString(4));
				entity.setType(rs.getString(5));
				entity.setServiceclass(rs.getString(6));
				entity.setAmount(rs.getDouble(7));
				entity.setStatus(rs.getString(8));
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
	public ArrayList<ServicesEntity> getServicesCar(){
		ArrayList<ServicesEntity> list = null;
		try {
			
			list = new ArrayList<ServicesEntity>(); 
			cs = conn.prepareCall(SelectServicesCar);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ServicesEntity entity = new ServicesEntity();
				entity.setId(rs.getInt(1));
				entity.setCompany(rs.getString(2));
				entity.setService(rs.getString(3));
				entity.setDescription(rs.getString(4));
				entity.setType(rs.getString(5));
				entity.setServiceclass(rs.getString(6));
				entity.setAmount(rs.getDouble(7));
				entity.setStatus(rs.getString(8));
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
