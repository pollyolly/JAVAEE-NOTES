package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.CurrencyEntity;

public class CurrencyDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private  String SelectAll = "{CALL sp_currency_read(?,?,?,?,?)}";
	private  String SelectAllById = "{CALL sp_currency_select_id(?,?,?,?,?,?,?)}";
	private  String InsertCurrency = "{CALL sp_currency_create(?,?,?,?)}";
	private  String UpdateCurrency = "{CALL sp_currency_update(?,?,?,?,?)}";
	
	public CurrencyDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean insertCurrency(CurrencyEntity enty){
		try {
			cs = conn.prepareCall(InsertCurrency);
			cs.setString(1, enty.getName());
			cs.setString(2, enty.getCountry());
			cs.setDouble(3, enty.getRate());
			cs.setInt(4, enty.getStatusid());
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
	
	public boolean updateCurrency(CurrencyEntity enty){
		try {
			cs = conn.prepareCall(UpdateCurrency);
			cs.setString(1, enty.getName());
			cs.setString(2, enty.getCountry());
			cs.setDouble(3, enty.getRate());
			cs.setInt(4, enty.getStatusid());
			cs.setInt(5, enty.getId());
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
	
	public ArrayList<CurrencyEntity> getCurrencyList(){
		ArrayList<CurrencyEntity> list = null;
		try {
			list = new ArrayList<CurrencyEntity>(); 
			cs = conn.prepareCall(SelectAll);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.DECIMAL);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CurrencyEntity entity = new CurrencyEntity();
				entity.setId(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setCountry(rs.getString(3));
				entity.setRate(rs.getDouble(4));
				entity.setStatus(rs.getString(5));
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

	
	public ArrayList<CurrencyEntity> getCurrencyById(int id){
		ArrayList<CurrencyEntity> list = null;
		try {
			list = new ArrayList<CurrencyEntity>(); 
			cs = conn.prepareCall(SelectAllById);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.DECIMAL);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.setInt(7, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CurrencyEntity entity = new CurrencyEntity();
				entity.setId(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setCountry(rs.getString(3));
				entity.setRate(rs.getDouble(4));
				entity.setStatus(rs.getString(5));
				entity.setStatusid(rs.getInt(6));
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
