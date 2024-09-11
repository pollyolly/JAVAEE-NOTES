package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.CardInformationEntity;

public class CardInformationDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private int status;
	private  String SelectOwn = "{CALL sp_r_owner(?,?)}";
	private  String SelectType = "{CALL sp_r_cardtype(?,?)}";
	private  String SelectAll = "{CALL sp_cardinformation_read(?,?,?,?,?,?,?,?,?,?,?,?)}";
	private  String SelectAllById = "{CALL sp_cardinformation_select_id(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private  String Insert = "{CALL sp_cardinformation_create(?,?,?,?,?,?)}";
	private  String Update = "{CALL sp_cardinformation_update(?,?,?,?,?,?,?)}";
	
	public CardInformationDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public int insertCardInformation(CardInformationEntity entity){
		try {
			cs = conn.prepareCall(Insert);
			cs.setString(1, entity.getCardnumber());
			cs.setString(2, entity.getExpirydate());
			cs.setInt(3, entity.getCardtypeid());
			cs.setInt(4, entity.getOwnershipid());
			cs.setInt(5, entity.getEmployeeid());
			cs.setInt(6, entity.getStatusid());
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
	public int updateCardInformation(CardInformationEntity entity){
		try {
			cs = conn.prepareCall(Update);
			cs.setString(1, entity.getCardnumber());
			cs.setString(2, entity.getExpirydate());
			cs.setInt(3, entity.getCardtypeid());
			cs.setInt(4, entity.getOwnershipid());
			cs.setInt(5, entity.getEmployeeid());
			cs.setInt(6, entity.getStatusid());
			cs.setInt(7, entity.getCardid());
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
	
	public ArrayList<CardInformationEntity> getCardInformationListById(int id){
		ArrayList<CardInformationEntity> list = null;
		try {
			list = new ArrayList<CardInformationEntity>(); 
			cs = conn.prepareCall(SelectAllById);
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
				CardInformationEntity entity = new CardInformationEntity();
				entity.setCardid(rs.getInt(1));
				entity.setCardnumber(rs.getString(2));
				entity.setExpirydate(rs.getString(3));
				entity.setCardtype(rs.getString(4));
				entity.setOwnership(rs.getString(5));
				entity.setEmployee(rs.getString(6));
				entity.setDepartment(rs.getString(7));
				entity.setStatus(rs.getString(8));
				entity.setCardtypeid(rs.getInt(9));
				entity.setOwnershipid(rs.getInt(10));
				entity.setEmployeeid(rs.getInt(11));
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
	
	public ArrayList<CardInformationEntity> getAllCardInformationList(){
		ArrayList<CardInformationEntity> list = null;
		try {
			list = new ArrayList<CardInformationEntity>(); 
			cs = conn.prepareCall(SelectAll);
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
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CardInformationEntity entity = new CardInformationEntity();
				entity.setCardid(rs.getInt(1));
				entity.setCardnumber(rs.getString(2));
				entity.setExpirydate(rs.getString(3));
				entity.setCardtype(rs.getString(4));
				entity.setOwnership(rs.getString(5));
				entity.setEmployee(rs.getString(6));
				entity.setDepartment(rs.getString(7));
				entity.setStatus(rs.getString(8));
				entity.setCardtypeid(rs.getInt(9));
				entity.setOwnershipid(rs.getInt(10));
				entity.setEmployeeid(rs.getInt(11));
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
	
	public ArrayList<CardInformationEntity> getCardtypeList(){
		ArrayList<CardInformationEntity> list = null;
		try {
			list = new ArrayList<CardInformationEntity>(); 
			cs = conn.prepareCall(SelectType);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CardInformationEntity entity = new CardInformationEntity();
				entity.setCardtypeid(rs.getInt(1));
				entity.setCardtype(rs.getString(2));
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
	
	public ArrayList<CardInformationEntity> getOwnershipList(){
		ArrayList<CardInformationEntity> list = null;
		try {
			list = new ArrayList<CardInformationEntity>(); 
			cs = conn.prepareCall(SelectOwn);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CardInformationEntity entity = new CardInformationEntity();
				entity.setOwnershipid(rs.getInt(1));
				entity.setOwnership(rs.getString(2));
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
