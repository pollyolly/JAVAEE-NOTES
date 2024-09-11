package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.CompanyPolicyEntity;

public class CompanyPolicyDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private int status;
	private  String SelectAll = "{CALL sp_companypolicy_read(?,?,?,?,?,?,?)}";
	private  String SelectAllById = "{CALL sp_companypolicy_select_id(?,?,?,?,?,?,?,?)}";
	private  String InsertPolicy = "{CALL sp_companypolicy_create(?,?,?,?,?)}";
	private  String UpdatePolicy = "{CALL sp_companypolicy_update(?,?,?,?,?,?)}";
	private String Policy = "{CALL sp_companypolicy_select_policy(?,?,?,?)}";
	public CompanyPolicyDa() {
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// TODO Auto-generated constructor stub
	}
	
	public int insertCompanyPolicy(CompanyPolicyEntity enty){
		try {
			cs = conn.prepareCall(InsertPolicy);
			cs.setInt(1, enty.getExpensedays());
			cs.setDouble(2, enty.getReceiptamount());
			cs.setDouble(3, enty.getMaxexpense());
			cs.setDouble(4, enty.getMaxbudget());
			cs.setInt(5, enty.getStatusid());
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
	public int updateCompanyPolicy(CompanyPolicyEntity enty){
		try {
			cs = conn.prepareCall(UpdatePolicy);
			cs.setInt(1, enty.getExpensedays());
			cs.setDouble(2, enty.getReceiptamount());
			cs.setDouble(3, enty.getMaxexpense());
			cs.setDouble(4, enty.getMaxbudget());
			cs.setInt(5, enty.getStatusid());
			cs.setInt(6, enty.getPolicyid());
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

	public ArrayList<CompanyPolicyEntity> getPolicy(){
		ArrayList<CompanyPolicyEntity> list = null;
		try {
			list = new ArrayList<CompanyPolicyEntity>(); 
			cs = conn.prepareCall(Policy);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.DECIMAL);
			cs.registerOutParameter(3, Types.DECIMAL);
			cs.registerOutParameter(4, Types.DECIMAL);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CompanyPolicyEntity comp = new CompanyPolicyEntity();
				comp.setExpensedays(rs.getInt(1));
				comp.setReceiptamount(rs.getDouble(2));
				comp.setMaxexpense(rs.getDouble(3));
				comp.setMaxbudget(rs.getDouble(4));
				list.add(comp);
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
	
	public ArrayList<CompanyPolicyEntity> getAllCompanyPolicyList(){
		ArrayList<CompanyPolicyEntity> list = null;
		try {
			list = new ArrayList<CompanyPolicyEntity>(); 
			cs = conn.prepareCall(SelectAll);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.DECIMAL);
			cs.registerOutParameter(3, Types.DECIMAL);
			cs.registerOutParameter(4, Types.DECIMAL);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CompanyPolicyEntity comp = new CompanyPolicyEntity();
				comp.setExpensedays(rs.getInt(1));
				comp.setReceiptamount(rs.getDouble(2));
				comp.setMaxexpense(rs.getDouble(3));
				comp.setMaxbudget(rs.getDouble(4));
				comp.setStatus(rs.getString(5));
				comp.setStatusid(rs.getInt(6));
				comp.setPolicyid(rs.getInt(7));
				list.add(comp);
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
	public ArrayList<CompanyPolicyEntity> getAllCompanyPolicyListById(int id){
		ArrayList<CompanyPolicyEntity> list = null;
		try {
			list = new ArrayList<CompanyPolicyEntity>(); 
			cs = conn.prepareCall(SelectAllById);
			cs.setInt(8, id);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.DECIMAL);
			cs.registerOutParameter(3, Types.DECIMAL);
			cs.registerOutParameter(4, Types.DECIMAL);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				CompanyPolicyEntity comp = new CompanyPolicyEntity();
				comp.setExpensedays(rs.getInt(1));
				comp.setReceiptamount(rs.getDouble(2));
				comp.setMaxexpense(rs.getDouble(3));
				comp.setMaxbudget(rs.getDouble(4));
				comp.setStatus(rs.getString(5));
				comp.setStatusid(rs.getInt(6));
				comp.setPolicyid(rs.getInt(7));
				list.add(comp);
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
