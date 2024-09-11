package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.CashAdvanceEntity;
import com.TravelEntity.TravelOrderEntity;

public class TravelOrderDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private String SelectAllTO = "{CALL sp_t_travelorder_read(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private String Insert = "{CALL sp_t_travelorder_create(?,?,?,?,?)}";
	private String Import = "{CALL sp_t_travelorder_import(?,?,?,?,?,?,?)}";
	private String Destination = "{CALL sp_r_destination(?,?)}";
	private String Priority = "{CALL sp_r_priority(?,?)}";
	private String Tono = "{CALL sp_t_travelorder_tono(?,?)}";
	private String SelectTono = "{CALL sp_t_travelorder_select_tono(?,?,?)}";
	private String Comment = "{CALL sp_t_travelorder_comment(?,?)}";
	private String SelectComment = "{CALL sp_t_travelorder_comment_select_id(?,?,?)}";
	private String Status = "{CALL sp_t_travelorder_status_update(?,?,?)}";
	
	private String SelectToEmployee = "{CALL sp_r_travelorderlistpersonnel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public TravelOrderDa() {
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertStatus(TravelOrderEntity entity){
		try {
			cs = conn.prepareCall(Status);
			cs.setInt(1, entity.getStatusid());
			cs.setInt(2, entity.getOfficerid());
			cs.setInt(3, entity.getId());
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
	
	
	public boolean insertComment(TravelOrderEntity entity){
		try {
			cs = conn.prepareCall(Comment);
			cs.setInt(1, entity.getId());
			cs.setString(2, entity.getComment());
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
	
	public ArrayList<TravelOrderEntity> getCommentById(int id){
		ArrayList<TravelOrderEntity> list = null;
		try {
			list = new ArrayList<TravelOrderEntity>();
			cs = conn.prepareCall(SelectComment);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.setInt(3, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelOrderEntity entity = new TravelOrderEntity();
				entity.setId(rs.getInt(1));
				entity.setComment(rs.getString(2));
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
	
	public boolean insertTravelOrder(TravelOrderEntity entity){
		try {
			cs = conn.prepareCall(Insert);
			cs.setString(1, entity.getTodate());
			cs.setString(2, entity.getPurpose());
			cs.setInt(3, entity.getPriorityid());
			cs.setInt(4, entity.getEmployeeid());
			cs.setInt(5, entity.getDestinationid());
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
	
	public boolean importTravelOrder(TravelOrderEntity entity){
		try {
			cs = conn.prepareCall(Import);
			cs.setString(1, entity.getTodate());
			cs.setString(2, entity.getPurpose());
			cs.setInt(3, entity.getPriorityid());
			cs.setInt(4, entity.getEmployeeid());
			cs.setInt(5, entity.getStatusid());
			cs.setInt(6, entity.getOfficerid());
			cs.setInt(7, entity.getDestinationid());
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
	
	public boolean updateTravelOrder(TravelOrderEntity entity){
		try {
			cs = conn.prepareCall(Insert);
			cs.setInt(1, entity.getId());
			cs.setInt(2, entity.getStatusid());
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
	
	public ArrayList<TravelOrderEntity> getTravelOrderList(){
		ArrayList<TravelOrderEntity> list = null;
		try {
			list = new ArrayList<TravelOrderEntity>();
			cs = conn.prepareCall(SelectAllTO);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.INTEGER);
			cs.registerOutParameter(12, Types.INTEGER);
			cs.registerOutParameter(13, Types.INTEGER);
			cs.registerOutParameter(14, Types.INTEGER);
			cs.registerOutParameter(15, Types.INTEGER);
			cs.registerOutParameter(16, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelOrderEntity entity = new TravelOrderEntity();
				entity.setTono(rs.getString(1));
				entity.setTodate(rs.getString(2));
				entity.setName(rs.getString(3));
				entity.setDepartment(rs.getString(4));
				entity.setPurpose(rs.getString(5));
				entity.setDestination(rs.getString(6));
				entity.setPriority(rs.getString(7));
				entity.setStatus(rs.getString(8));
				entity.setOfficername(rs.getString(9));
				entity.setId(rs.getInt(10));
				entity.setPriorityid(rs.getInt(11));
				entity.setEmployeeid(rs.getInt(12));
				entity.setStatusid(rs.getInt(13));
				entity.setOfficerid(rs.getInt(14));
				entity.setDestinationid(rs.getInt(15));
				entity.setComment(rs.getString(16));
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
	public ArrayList<TravelOrderEntity> getTravelOrderListEmployee(int empid){
		ArrayList<TravelOrderEntity> list = null;
		try {
			list = new ArrayList<TravelOrderEntity>();
			cs = conn.prepareCall(SelectToEmployee);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.INTEGER);
			cs.registerOutParameter(12, Types.INTEGER);
			cs.registerOutParameter(13, Types.INTEGER);
			cs.registerOutParameter(14, Types.INTEGER);
			cs.registerOutParameter(15, Types.INTEGER);
			cs.registerOutParameter(16, Types.VARCHAR);
			cs.setInt(17, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelOrderEntity entity = new TravelOrderEntity();
				entity.setTono(rs.getString(1));
				entity.setTodate(rs.getString(2));
				entity.setName(rs.getString(3));
				entity.setDepartment(rs.getString(4));
				entity.setPurpose(rs.getString(5));
				entity.setDestination(rs.getString(6));
				entity.setPriority(rs.getString(7));
				entity.setStatus(rs.getString(8));
				entity.setOfficername(rs.getString(9));
				entity.setId(rs.getInt(10));
				entity.setPriorityid(rs.getInt(11));
				entity.setEmployeeid(rs.getInt(12));
				entity.setStatusid(rs.getInt(13));
				entity.setOfficerid(rs.getInt(14));
				entity.setDestinationid(rs.getInt(15));
				entity.setComment(rs.getString(16));
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
	public ArrayList<TravelOrderEntity> getDestination(){
		ArrayList<TravelOrderEntity> list = null;
		try {
			list = new ArrayList<TravelOrderEntity>();
			cs = conn.prepareCall(Destination);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelOrderEntity entity = new TravelOrderEntity();
				entity.setDestinationid(rs.getInt(1));
				entity.setDestination(rs.getString(2));
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
	public ArrayList<TravelOrderEntity> getPriority(){
		ArrayList<TravelOrderEntity> list = null;
		try {
			list = new ArrayList<TravelOrderEntity>();
			cs = conn.prepareCall(Priority);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelOrderEntity entity = new TravelOrderEntity();
				entity.setPriorityid(rs.getInt(1));
				entity.setPriority(rs.getString(2));
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
	
	public ArrayList<TravelOrderEntity> getTOno(){
		ArrayList<TravelOrderEntity> list = null;
		try {
			list = new ArrayList<TravelOrderEntity>();
			cs = conn.prepareCall(Tono);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelOrderEntity entity = new TravelOrderEntity();
				entity.setId(rs.getInt(2));
				entity.setTono(rs.getString(1));
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

	public ArrayList<TravelOrderEntity> getToByTono(String tono){
		ArrayList<TravelOrderEntity> list = null;
		try {
			list = new ArrayList<TravelOrderEntity>();
			cs = conn.prepareCall(SelectTono);
			cs.setString(3, tono);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelOrderEntity entity = new TravelOrderEntity();
				entity.setId(rs.getInt(1));
				entity.setName(rs.getString(2));
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
