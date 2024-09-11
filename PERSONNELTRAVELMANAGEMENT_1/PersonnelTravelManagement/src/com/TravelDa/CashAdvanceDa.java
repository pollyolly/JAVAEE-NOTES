package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.CashAdvanceEntity;
import com.TravelEntity.PositionEntity;
import com.TravelEntity.TravelOrderEntity;

public class CashAdvanceDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private String Insert = "{CALL sp_t_cashadvance_create(?,?,?,?)}";
	private String Update = "";
	private String Import = "";
	private String SelectAllCA = "{CALL sp_t_cashadvance_read(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private String Comment = "{CALL sp_t_cashadvance_comment(?,?)}";
	private String SelectComment = "{CALL sp_t_cashadvance_comment_select_id(?,?,?)}";
	private String Status = "{CALL sp_t_cashadvance_status_update(?,?,?)}";
	public CashAdvanceDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean insertStatus(CashAdvanceEntity entity){
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

	public boolean insertComment(CashAdvanceEntity entity){
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
	
	public ArrayList<CashAdvanceEntity> getCommentById(int id){
		ArrayList<CashAdvanceEntity> list = null;
		try {
			list = new ArrayList<CashAdvanceEntity>();
			cs = conn.prepareCall(SelectComment);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.setInt(3, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CashAdvanceEntity entity = new CashAdvanceEntity();
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
	
	public boolean insertCashAdvance(CashAdvanceEntity entity){
		try {
			cs = conn.prepareCall(Insert);
			cs.setString(1, entity.getCadate());
			cs.setString(2, entity.getPurpose());
			cs.setDouble(3, entity.getAmount());
			cs.setInt(4, entity.getOrderid());
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
	
	public boolean updateCashAdvance(CashAdvanceEntity entity){
		try {
			cs = conn.prepareCall(Update);
			cs.setInt(1, entity.getOfficerid());
			cs.setInt(2, entity.getStatusid());
			cs.setInt(3, entity.getId());
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
	public ArrayList<CashAdvanceEntity> getCashAdvanceList(){
		ArrayList<CashAdvanceEntity> list = null;
		try {
			list = new ArrayList<CashAdvanceEntity>(); 
			cs = conn.prepareCall(SelectAllCA);
			cs.registerOutParameter(1, Types.VARCHAR);
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
			cs.registerOutParameter(13, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CashAdvanceEntity entity = new CashAdvanceEntity();
				entity.setCadate(rs.getString(1));
				entity.setTono(rs.getString(2));
				entity.setEmployee(rs.getString(3));
				entity.setDepartment(rs.getString(4));
				entity.setAmount(rs.getDouble(5));
				entity.setPurpose(rs.getString(6));
				entity.setStatus(rs.getString(7));
				entity.setOfficer(rs.getString(8));
				entity.setId(rs.getInt(9));
				entity.setOrderid(rs.getInt(10));
				entity.setStatusid(rs.getInt(11));
				entity.setOfficerid(rs.getInt(12));
				entity.setComment(rs.getString(13));
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
