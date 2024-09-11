package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.PositionEntity;

public class PositionDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private  String SelectAllById = "{CALL sp_position_select_id(?,?,?,?,?,?)}";
	private  String SelectAll = "{CALL sp_position_read(?,?,?,?,?)}";
	private  String Insert = "{CALL sp_position_create(?,?,?)}";
	private  String Update = "{CALL sp_position_update(?,?,?,?)}";
	private  String Position = "{CALL sp_r_position(?,?)}";
	public PositionDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	public boolean insertPosition(PositionEntity entity){
		try {
			cs = conn.prepareCall(Insert);
			cs.setString(1, entity.getPosition());
			cs.setString(2, entity.getDescription());
			cs.setInt(3, entity.getStatusid());
			status = cs.execute();
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
	
	public boolean updatePosition(PositionEntity entity){
		try {
			cs = conn.prepareCall(Update);
			cs.setString(1, entity.getPosition());
			cs.setString(2, entity.getDescription());
			cs.setInt(3, entity.getStatusid());
			cs.setInt(4, entity.getPositionid());
			status = cs.execute();
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
	public ArrayList<PositionEntity> getAllPositionList(){
		ArrayList<PositionEntity> list = null;
		try {
			list = new ArrayList<PositionEntity>(); 
			cs = conn.prepareCall(SelectAll);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				PositionEntity entity = new PositionEntity();
			entity.setPositionid(rs.getInt(1));
			entity.setPosition(rs.getString(2));
			entity.setDescription(rs.getString(3));
			entity.setStatus(rs.getString(4));
			entity.setStatusid(rs.getInt(5));
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
	public ArrayList<PositionEntity> getPositionListById(int id){
		ArrayList<PositionEntity> list = null;
		try {
			list = new ArrayList<PositionEntity>(); 
			cs = conn.prepareCall(SelectAllById);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.setInt(6, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				PositionEntity entity = new PositionEntity();
			entity.setPositionid(rs.getInt(1));
			entity.setPosition(rs.getString(2));
			entity.setDescription(rs.getString(3));
			entity.setStatus(rs.getString(4));
			entity.setStatusid(rs.getInt(5));
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
	public ArrayList<PositionEntity> getPosition(){
		ArrayList<PositionEntity> list = null;
		try {
			list = new ArrayList<PositionEntity>(); 
			cs = conn.prepareCall(Position);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				PositionEntity entity = new PositionEntity();
			entity.setPositionid(rs.getInt(1));
			entity.setPosition(rs.getString(2));
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
