package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.TravelExpenseEntity;
import com.TravelEntity.TravelExpenseListEntity;
import com.TravelEntity.TravelPlanEntity;

public class TravelExpenseDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	private String SelectExpense = "{CALL sp_t_travelexpense_read(?,?,?,?,?,?,?)}";
	private String InsertExpense = "{CALL sp_t_travelexpense_create(?,?,?)}";
	private String InsertExpenseList = "{CALL sp_t_travelexpenselist_create(?,?,?,?,?,?,?,?,?)}";
	private String InsertExpenseListHotel = "{CALL sp_t_travelexpenselist_hotel(?,?)}";
	private String InsertExpenseListCar = "{CALL sp_t_travelexpenselist_car(?,?,?,?)}";
	private String InsertExpenseListFlight = "{CALL sp_t_travelexpenselist_flight(?,?,?,?,?)}";
	private String InsertExpenseListMileage = "{CALL sp_t_travelexpenselist_mileage(?,?,?)}";
	private String InsertExpenseListMeal = "{CALL sp_t_travelexpenselist_meal(?,?)}";
	private String InsertExpenseListMisc = "{CALL sp_t_travelexpenselist_misc(?,?)}";
	private String SelectExpenseByOrderId = "{CALL sp_t_travelexpense_select_orderid(?,?,?,?,?,?,?,?,?,?,?,?)}";
	private String SelectExpenseListByOrderId = "{CALL sp_t_travelexpenselist_select_orderid(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private String SelectExpenseReport = "{CALL sp_r_travelexpenselist(?,?,?,?,?,?,?,?,?)}";
	private String Comment = "{CALL sp_t_travelexpense_comment(?,?)}";
	private String SelectComment = "{CALL sp_t_travelexpense_comment_select_id(?,?,?)}";
	private String Status = "{CALL sp_t_travelexpense_status_update(?,?,?)}";
	
	private String SelectExpenseEmployee = "{CALL sp_t_travelexpensepersonnel(?,?,?,?,?,?,?,?)}";
	private String SelectExpenseReportEmployee = "{CALL sp_r_travelexpenselistpersonnel(?,?,?,?,?,?,?,?,?,?)}";
	public TravelExpenseDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertStatus(TravelExpenseEntity entity){
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
	
	public boolean insertComment(TravelExpenseEntity entity){
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
	
	public ArrayList<TravelExpenseEntity> getCommentById(int id){
		ArrayList<TravelExpenseEntity> list = null;
		try {
			list = new ArrayList<TravelExpenseEntity>();
			cs = conn.prepareCall(SelectComment);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.setInt(3, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelExpenseEntity entity = new TravelExpenseEntity();
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
	
	public boolean insertTravelExpense(TravelExpenseEntity entity){
		try {
			cs = conn.prepareCall(InsertExpense);
			cs.setString(1, entity.getFromdate());
			cs.setString(2, entity.getTodate());
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
	
	public boolean insertTravelExpenseList(TravelExpenseListEntity entity){
		try {
			cs = conn.prepareCall(InsertExpenseList);
			cs.setString(1, entity.getPcn());
			cs.setInt(2, entity.getId());
			cs.setInt(3, entity.getTypeid());
			cs.setString(4, entity.getDate());
			cs.setInt(5, entity.getReimburse());
			cs.setInt(6, entity.getBillable());
			cs.setString(7, entity.getReason());
			cs.setDouble(8, entity.getAmount());
			cs.setString(9, entity.getVendor());
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
	
	public boolean insertTravelExpenseListHotel(TravelExpenseListEntity entity){
		try {
			cs = conn.prepareCall(InsertExpenseListHotel);
			cs.setString(1, entity.getCheckin());
			cs.setString(2, entity.getCheckout());
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
	
	public boolean insertTravelExpenseListCar(TravelExpenseListEntity entity){
		try {
			cs = conn.prepareCall(InsertExpenseListCar);
			cs.setString(1, entity.getCfrom());
			cs.setString(2, entity.getCto());
			cs.setString(3, entity.getPickup());
			cs.setString(4, entity.getDropoff());
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
	
	public boolean insertTravelExpenseListFlight(TravelExpenseListEntity entity){
		try {
			cs = conn.prepareCall(InsertExpenseListFlight);
			cs.setString(1, entity.getDeparture());
			cs.setString(2, entity.getReturns());
			cs.setInt(3, entity.getStopover());
			cs.setString(4, entity.getFfrom());
			cs.setString(5, entity.getFto());
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
	
	public boolean insertTravelExpenseListMisc(TravelExpenseListEntity entity){
		try {
			cs = conn.prepareCall(InsertExpenseListMisc);
			cs.setString(1, entity.getMiscvendor());
			cs.setString(2, entity.getDescription());
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
	
	public boolean insertTravelExpenseListMeal(TravelExpenseListEntity entity){
		try {
			cs = conn.prepareCall(InsertExpenseListMeal);
			cs.setString(1, entity.getMvendor());
			cs.setString(2, entity.getDescription());
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
	
	public boolean insertTravelExpenseListMileage(TravelExpenseListEntity entity){
		try {
			cs = conn.prepareCall(InsertExpenseListMileage);
			cs.setString(1, entity.getMfrom());
			cs.setString(2, entity.getMto());
			cs.setInt(3, entity.getDistance());
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
	
	public boolean updateTravelExpense(TravelPlanEntity entity){
		try {
			cs = conn.prepareCall("");
			//cs.setString(1, entity.getFromdate());
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
	
	public ArrayList<TravelExpenseEntity> getTravelExpense(){
		ArrayList<TravelExpenseEntity> list = null;
		try {
			list = new ArrayList<TravelExpenseEntity>();
			cs = conn.prepareCall(SelectExpense);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelExpenseEntity entity = new TravelExpenseEntity();
				entity.setId(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setTono(rs.getString(3));
				entity.setFromdate(rs.getString(4));
				entity.setTodate(rs.getString(5));
				entity.setStatus(rs.getString(6));
				entity.setComment(rs.getString(7));
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
	

	public ArrayList<TravelExpenseEntity> getTravelExpensePersonnel(int empid){
		ArrayList<TravelExpenseEntity> list = null;
		try {
			list = new ArrayList<TravelExpenseEntity>();
			cs = conn.prepareCall(SelectExpenseEmployee);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.setInt(8, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelExpenseEntity entity = new TravelExpenseEntity();
				entity.setId(rs.getInt(1));
				entity.setName(rs.getString(2));
				entity.setTono(rs.getString(3));
				entity.setFromdate(rs.getString(4));
				entity.setTodate(rs.getString(5));
				entity.setStatus(rs.getString(6));
				entity.setComment(rs.getString(7));
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
	
	
	public ArrayList<TravelExpenseEntity> getTravelExpenseByOrderId(int odid){
		ArrayList<TravelExpenseEntity> list = null;
		try {
			list = new ArrayList<TravelExpenseEntity>();
			cs = conn.prepareCall(SelectExpenseByOrderId);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.DECIMAL);
			cs.registerOutParameter(10, Types.DECIMAL);
			cs.registerOutParameter(11, Types.DECIMAL);
			//cs.registerOutParameter(12, Types.DECIMAL);
			cs.setInt(12, odid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelExpenseEntity entity = new TravelExpenseEntity();
				entity.setId(rs.getInt(1));
				entity.setTono(rs.getString(2));
				entity.setName(rs.getString(3));
				entity.setFromdate(rs.getString(4));
				entity.setTodate(rs.getString(5));
				entity.setDestination(rs.getString(6));
				entity.setOfficername(rs.getString(7));
				entity.setStatus(rs.getString(8));
				entity.setCashadvance(rs.getDouble(9));
				entity.setReimburse(rs.getDouble(10));
				entity.setNonreimburse(rs.getDouble(11));
				//entity.setTotal(rs.getDouble(12));
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
	
	public ArrayList<TravelExpenseListEntity> getTravelExpenseListByOrderId(int odid){
		ArrayList<TravelExpenseListEntity> list = null;
		try {
			list = new ArrayList<TravelExpenseListEntity>();
			cs = conn.prepareCall(SelectExpenseListByOrderId);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.DECIMAL);
			cs.registerOutParameter(8, Types.VARCHAR);
			//MEAL
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			//MISC
			cs.registerOutParameter(11, Types.VARCHAR);
			cs.registerOutParameter(12, Types.VARCHAR);
			//FLIGHT
			cs.registerOutParameter(13, Types.VARCHAR);
			cs.registerOutParameter(14, Types.VARCHAR);
			cs.registerOutParameter(15, Types.VARCHAR);
			cs.registerOutParameter(16, Types.VARCHAR);
			cs.registerOutParameter(17, Types.INTEGER);
			//HOTEL
			cs.registerOutParameter(18, Types.VARCHAR);
			cs.registerOutParameter(19, Types.VARCHAR);
			//MILEAGE
			cs.registerOutParameter(20, Types.VARCHAR);
			cs.registerOutParameter(21, Types.VARCHAR);
			cs.registerOutParameter(22, Types.INTEGER);
			//CAR
			cs.registerOutParameter(23, Types.VARCHAR);
			cs.registerOutParameter(24, Types.VARCHAR);
			cs.registerOutParameter(25, Types.VARCHAR);
			cs.registerOutParameter(26, Types.VARCHAR);
			cs.setInt(27, odid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelExpenseListEntity entity = new TravelExpenseListEntity();
				entity.setPcn(rs.getString(1));
				entity.setType(rs.getString(2));
				entity.setDate(rs.getString(3));
				entity.setReimburse(rs.getInt(4));
				entity.setBillable(rs.getInt(5));
				entity.setReason(rs.getString(6));
				entity.setAmount(rs.getDouble(7));
				entity.setVendor(rs.getString(8));
				//meal
				entity.setMvendor(rs.getString(9));
				entity.setMdescription(rs.getString(10));
				//MISC
				entity.setMiscvendor(rs.getString(11));
				entity.setDescription(rs.getString(12));
				//FLIGHT
				entity.setFfrom(rs.getString(13));
				entity.setFto(rs.getString(14));
				entity.setDeparture(rs.getString(15));
				entity.setReturns(rs.getString(16));
				entity.setStopover(rs.getInt(17));
				//HOTEL
				entity.setCheckin(rs.getString(18));
				entity.setCheckout(rs.getString(19));
				//MILEAGE
				entity.setMfrom(rs.getString(20));
				entity.setMto(rs.getString(21));
				entity.setDistance(rs.getInt(22));
				//CAR RENTAL
				entity.setCfrom(rs.getString(23));
				entity.setCto(rs.getString(24));
				entity.setPickup(rs.getString(25));
				entity.setDropoff(rs.getString(26));
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
	
	public ArrayList<TravelExpenseEntity> getTravelExpenseListReport(){
		ArrayList<TravelExpenseEntity> list = null;
		try {
			list = new ArrayList<TravelExpenseEntity>();
			cs = conn.prepareCall(SelectExpenseReport);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.DECIMAL);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelExpenseEntity entity = new TravelExpenseEntity();
				entity.setId(rs.getInt(1));
				entity.setTono(rs.getString(2));
				entity.setName(rs.getString(3));
				entity.setFromdate(rs.getString(4));
				entity.setTodate(rs.getString(5));
				entity.setDestination(rs.getString(6));
				entity.setTotal(rs.getDouble(7));
				entity.setStatus(rs.getString(8));
				entity.setOfficername(rs.getString(9));
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
	
	public ArrayList<TravelExpenseEntity> getTravelExpenseListReportEmployee(int empid){
		ArrayList<TravelExpenseEntity> list = null;
		try {
			list = new ArrayList<TravelExpenseEntity>();
			cs = conn.prepareCall(SelectExpenseReportEmployee);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.DECIMAL);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.setInt(10, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelExpenseEntity entity = new TravelExpenseEntity();
				entity.setId(rs.getInt(1));
				entity.setTono(rs.getString(2));
				entity.setName(rs.getString(3));
				entity.setFromdate(rs.getString(4));
				entity.setTodate(rs.getString(5));
				entity.setDestination(rs.getString(6));
				entity.setTotal(rs.getDouble(7));
				entity.setStatus(rs.getString(8));
				entity.setOfficername(rs.getString(9));
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
