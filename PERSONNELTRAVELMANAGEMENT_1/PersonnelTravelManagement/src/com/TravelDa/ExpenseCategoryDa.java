package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.ExpenseCategoryEntity;

public class ExpenseCategoryDa {
	private Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private  String SelectAllById = "{CALL sp_expensecategory_select_id(?,?,?,?,?,?,?,?)}";
	private  String SelectAll = "{CALL sp_expensecategory_read(?,?,?,?,?,?,?)}";
	private  String Insert = "{CALL sp_expensecategory_create(?,?,?,?)}";
	private  String Update = "{CALL sp_expensecategory_update(?,?,?,?,?)}";
	
	public ExpenseCategoryDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public boolean insertExpenseCategory(ExpenseCategoryEntity entity){
		try {
			cs = conn.prepareCall(Insert);
			cs.setString(1, entity.getName());
			cs.setDouble(2, entity.getRate());
			cs.setInt(3, entity.getDepartmentid());
			cs.setInt(4, entity.getStatusid());
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
	public boolean updateExpenseCategory(ExpenseCategoryEntity entity){
		try {
			cs = conn.prepareCall(Update);
			cs.setString(1, entity.getName());
			cs.setDouble(2, entity.getRate());
			cs.setInt(3, entity.getDepartmentid());
			cs.setInt(4, entity.getStatusid());
			cs.setInt(5, entity.getExpensecatid());
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
	
	public ArrayList<ExpenseCategoryEntity> getAllExpenseCategoryById(int id){
		ArrayList<ExpenseCategoryEntity> list = null;
		try {
			list = new ArrayList<ExpenseCategoryEntity>(); 
			cs = conn.prepareCall(SelectAllById);
			cs.setInt(8, id);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.DECIMAL);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ExpenseCategoryEntity entity = new ExpenseCategoryEntity();
				entity.setExpensecatid(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setRate(rs.getDouble(3));
				entity.setDepartment(rs.getString(4));
				entity.setStatus(rs.getString(5));
				entity.setDepartmentid(rs.getInt(6));
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
	
	public ArrayList<ExpenseCategoryEntity> getAllExpenseCategory(){
		ArrayList<ExpenseCategoryEntity> list = null;
		try {
			list = new ArrayList<ExpenseCategoryEntity>(); 
			cs = conn.prepareCall(SelectAll);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.DECIMAL);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ExpenseCategoryEntity entity = new ExpenseCategoryEntity();
				entity.setExpensecatid(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setRate(rs.getDouble(3));
				entity.setDepartment(rs.getString(4));
				entity.setStatus(rs.getString(5));
				entity.setDepartmentid(rs.getInt(6));
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
