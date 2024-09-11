package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.ChartEntity;
import com.TravelEntity.DashboardEntity;

public class DashboardDa {
	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	
	private String TOApprove = "SELECT COUNT(*) AS approve FROM ptms_t_travelorder WHERE statusid = 7";
	private String TOCancel= "SELECT COUNT(*) AS approve FROM ptms_t_travelorder WHERE statusid = 8";
	private String Plan = "SELECT COUNT(*) AS plan FROM ptms_t_travelplan";
	private String Expense = "SELECT COUNT(*) AS expense FROM `ptms_t_travelexpense`";
	private String Aexpense = "{CALL sp_a_expense(?,?)}";
	private String Atravel = "{CALL sp_a_travel(?,?)}";
	private String CountToPending = "SELECT  COUNT(*) AS ct FROM ptms_t_travelorder AS lst WHERE lst.statusid = 10 ;";
	private String CountPlanPending = "SELECT  COUNT(*) AS ct FROM ptms_t_travelplan AS lst WHERE lst.statusid = 10";
	private String CountExpensePending = "SELECT COUNT(*) AS ct FROM  ptms_t_travelexpense AS xp WHERE xp.statusid = 10";
	private String AexpensePersonnel = "{CALL sp_a_expensepersonnel(?,?,?)}";
	private String AtravelPersonnel = "{CALL sp_a_travelpersonnel(?,?,?)}";
	private String CountExpPending = "{CALL sp_count_expensependingpersonnel(?,?)}";
	private String CountExpApprove = "{CALL sp_count_expenseapprovepersonnel(?,?)}";
	private String CountExpNotapprove = "{CALL sp_count_expensenotapprovepersonnel(?,?)}";
	
	public DashboardDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public ArrayList<ChartEntity> getAnalyticExpensePersonnel(int empid){
		ArrayList<ChartEntity> list = null;
		try {
			list = new ArrayList<ChartEntity>();
			cs = conn.prepareCall(AexpensePersonnel);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.DECIMAL);
			cs.setInt(3, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ChartEntity entity = new ChartEntity();
				entity.setX(rs.getString(1));
				entity.setY(rs.getDouble(2));
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
	
	public ArrayList<ChartEntity> getAnalyticTravelPersonnel(int empid){
		ArrayList<ChartEntity> list = null;
		try {
			list = new ArrayList<ChartEntity>();
			cs = conn.prepareCall(AtravelPersonnel);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.DECIMAL);
			cs.setInt(3, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ChartEntity entity = new ChartEntity();
				entity.setX(rs.getString(1));
				entity.setY(rs.getDouble(2));
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
	
	public ArrayList<ChartEntity> getAnalyticExpense(){
		ArrayList<ChartEntity> list = null;
		try {
			list = new ArrayList<ChartEntity>();
			cs = conn.prepareCall(Aexpense);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.DECIMAL);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ChartEntity entity = new ChartEntity();
				entity.setX(rs.getString(1));
				entity.setY(rs.getDouble(2));
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
	
	
	
	public ArrayList<ChartEntity> getAnalyticTravel(){
		ArrayList<ChartEntity> list = null;
		try {
			list = new ArrayList<ChartEntity>();
			cs = conn.prepareCall(Atravel);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.DECIMAL);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				ChartEntity entity = new ChartEntity();
				entity.setX(rs.getString(1));
				entity.setY(rs.getDouble(2));
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
	
	public ArrayList<DashboardEntity> getTOapprove(){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(TOApprove);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setToapprove(rs.getInt(1));
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
	
	public ArrayList<DashboardEntity> getTOcancel(){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(TOCancel);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setTocancel(rs.getInt(1));
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
	
	
	public ArrayList<DashboardEntity> getTOplan(){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(Plan);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setPlan(rs.getInt(1));
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
	
	public ArrayList<DashboardEntity> getTOexpense(){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(Expense);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setExpense(rs.getInt(1));
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
	
	public ArrayList<DashboardEntity> getToPending(){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(CountToPending);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setCount(rs.getInt(1));
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
	
	public ArrayList<DashboardEntity> getPlanPending(){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(CountPlanPending);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setCount(rs.getInt(1));
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
	
	public ArrayList<DashboardEntity> getExpensePending(){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(CountExpensePending);
			
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setCount(rs.getInt(1));
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
	//=================================================================
	public ArrayList<DashboardEntity> getExpenseApprovePersonnel(int empid){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(CountExpApprove);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setCount(rs.getInt(1));
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
	public ArrayList<DashboardEntity> getExpenseNotapprovePersonnel(int empid){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(CountExpNotapprove);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setCount(rs.getInt(1));
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
	
	public ArrayList<DashboardEntity> getExpensePendingPersonnel(int empid){
		ArrayList<DashboardEntity> list = null;
		try {
			list = new ArrayList<DashboardEntity>(); 
			cs = conn.prepareCall(CountExpPending);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				DashboardEntity entity = new DashboardEntity();
				entity.setCount(rs.getInt(1));
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
