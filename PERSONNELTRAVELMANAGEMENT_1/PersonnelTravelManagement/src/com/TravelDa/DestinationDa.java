package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.DestinationEntity;

public class DestinationDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private int status;
	private String insertDest = "{CALL sp_destination_create(?,?,?,?,?)}";
	private String updateDest = "{CALL sp_destination_update(?,?,?,?,?,?)}";
	private String SelectList = "{CALL sp_destination_read(?,?,?,?,?,?)}";
	private String SelectById = "{CALL sp_destination_select_id(?,?,?,?,?,?,?,?)}";
	
	public DestinationDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public int insertDestination(DestinationEntity entity){
		try {
			cs = conn.prepareCall(insertDest);
			cs.setString(1, entity.getCode());
			cs.setString(2, entity.getCity());
			cs.setString(3, entity.getState());
			cs.setString(4, entity.getCountry());
			cs.setInt(5, entity.getStatusid());
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

	public int updateDestination(DestinationEntity entity){
		try {
			cs = conn.prepareCall(updateDest);
			cs.setString(1, entity.getCode());
			cs.setString(2, entity.getCity());
			cs.setString(3, entity.getState());
			cs.setString(4, entity.getCountry());
			cs.setInt(5, entity.getStatusid());
			cs.setInt(6, entity.getId());
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
	
	public ArrayList<DestinationEntity> getDestinationList(){
		ArrayList<DestinationEntity> list = null;
		try {
			list = new ArrayList<DestinationEntity>(); 
			cs = conn.prepareCall(SelectList);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DestinationEntity entity = new DestinationEntity();
				entity.setId(rs.getInt(1));
				entity.setCode(rs.getString(2));
				entity.setCity(rs.getString(3));
				entity.setState(rs.getString(4));
				entity.setCountry(rs.getString(5));
				entity.setStatus(rs.getString(6));
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
	
	public ArrayList<DestinationEntity> getDestinationById(int id){
		ArrayList<DestinationEntity> list = null;
		try {
			list = new ArrayList<DestinationEntity>(); 
			cs = conn.prepareCall(SelectById);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.setInt(8, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DestinationEntity entity = new DestinationEntity();
				entity.setId(rs.getInt(1));
				entity.setCode(rs.getString(2));
				entity.setCity(rs.getString(3));
				entity.setState(rs.getString(4));
				entity.setCountry(rs.getString(5));
				entity.setStatus(rs.getString(6));
				entity.setStatusid(rs.getInt(7));
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
