package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.CardInformationEntity;
import com.TravelEntity.TravelBudgetEntity;

public class TravelBudgetDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private String budgetlist = "{CALL sp_r_travelbudgetlist(?)}";
	public TravelBudgetDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public ArrayList<TravelBudgetEntity> getBudgetList(){
		ArrayList<TravelBudgetEntity> list = null;
		try {
			list = new ArrayList<TravelBudgetEntity>(); 
			cs = conn.prepareCall(budgetlist);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelBudgetEntity entity = new TravelBudgetEntity();
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

}
