package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.TravelOrderEntity;
import com.TravelEntity.TravelPlanEntity;
import com.TravelEntity.TravelPlanListEntity;

public class TravelPlanDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private boolean status = false;
	
	private String InsertPlan = "{CALL sp_t_travelplan_create(?,?,?,?,?,?,?,?)}";
	private String InsertPlanList = "{CALL sp_t_travelplanlist_create(?,?,?,?,?,?,?)}";
	private String InsertPlanListHotel = "{CALL sp_t_travelplanlist_hotel(?,?)}";
	private String InsertPlanListCar = "{CALL sp_t_travelplanlist_car(?,?,?,?)}";
	private String InsertPlanListFlight = "{CALL sp_t_travelplanlist_flight(?,?,?,?,?)}";
	private String InsertPlanListMisc = "{CALL sp_t_travelplanlist_misc(?,?,?)}";
	private String SelectPlanList = "{CALL sp_t_travelplanlist_select_tono(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private String SelectPlanByTono = "{CALL sp_t_travelplan_select_tono(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private String SelectPlan = "{CALL sp_t_travelplan_read(?,?,?,?,?,?,?,?,?,?,?)}";
	private String SelectPlan_2 = "{CALL sp_t_travelplan_select_2(?,?,?)}";
	private String SelectPlanReport = "{CALL sp_r_travelplanlist(?,?,?,?,?,?,?,?,?)}";
	private String Comment = "{CALL sp_t_travelplan_comment(?,?)}";
	private String SelectComment = "{CALL sp_t_travelplan_comment_select_id(?,?,?)}";
	private String Status = "{CALL sp_t_travelplan_status_update(?,?,?)}";
	private String SelectPlanReportEmployee = "{CALL sp_r_travelplanlistpersonnel(?,?,?,?,?,?,?,?,?)}";
	public TravelPlanDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertStatus(TravelPlanEntity entity){
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
	
	
	public boolean insertComment(TravelPlanEntity entity){
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
	
	public ArrayList<TravelPlanEntity> getCommentById(int id){
		ArrayList<TravelPlanEntity> list = null;
		try {
			list = new ArrayList<TravelPlanEntity>();
			cs = conn.prepareCall(SelectComment);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.setInt(3, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelPlanEntity entity = new TravelPlanEntity();
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
	
	public boolean insertTravelPlan(TravelPlanEntity entity){
		try {
			cs = conn.prepareCall(InsertPlan);
			cs.setString(1, entity.getFromdate());
			cs.setString(2, entity.getTodate());
			cs.setString(3, entity.getTono());
			cs.setDouble(4, entity.getFood());
			cs.setDouble(5, entity.getAllowance());
			cs.setDouble(6, entity.getAccommodation());
			cs.setDouble(7, entity.getTransportation());
			cs.setDouble(8, entity.getPerdiem());
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
	
	public boolean insertTravelPlanList(TravelPlanListEntity entity){
		try {
			cs = conn.prepareCall(InsertPlanList);
			cs.setString(1, entity.getPcn());
			cs.setString(2, entity.getTono());
			cs.setInt(3, entity.getServiceproviderid());
			cs.setInt(4, entity.getServiceid());
			cs.setInt(5, entity.getTypeid());
			cs.setString(6, entity.getPlanid());
			cs.setString(7, entity.getFile());
			
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
	//HOTEL
	public boolean insertTravelHotel(TravelPlanListEntity entity){
		try {
			cs = conn.prepareCall(InsertPlanListHotel);
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
	//HOTEL
	
	//CAR
	public boolean insertTravelCar(TravelPlanListEntity entity){
		try {
			cs = conn.prepareCall(InsertPlanListCar);
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
	//CAR
	
	//FLIGHT
	public boolean insertTravelFlight(TravelPlanListEntity entity){
		try {
			cs = conn.prepareCall(InsertPlanListFlight);
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
	//FLIGHT
	
	//MISCELLANEOUS
	public boolean insertTravelMisc(TravelPlanListEntity entity){
		try {
			cs = conn.prepareCall(InsertPlanListMisc);
			cs.setString(1, entity.getVendor());
			cs.setString(2, entity.getDescription());
			cs.setDouble(3, entity.getAmount());
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
	//MISCELLANEOUS
	
	public boolean updateTravelPlan(TravelPlanEntity entity){
		return status;
	}
	
	public ArrayList<TravelPlanEntity> getTravelPlan(String tono, String tpid){
		ArrayList<TravelPlanEntity> list = null;
		try {
			list = new ArrayList<TravelPlanEntity>();
			cs = conn.prepareCall(SelectPlanByTono);
			cs.setString(16, tpid);
			cs.setString(15, tono);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.DECIMAL);
			cs.registerOutParameter(7, Types.DECIMAL);
			cs.registerOutParameter(8, Types.DECIMAL);
			cs.registerOutParameter(9, Types.DECIMAL);
			cs.registerOutParameter(10, Types.DECIMAL);
			cs.registerOutParameter(11, Types.VARCHAR);
			cs.registerOutParameter(12, Types.VARCHAR);
			cs.registerOutParameter(13, Types.DECIMAL);
			cs.registerOutParameter(14, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelPlanEntity entity = new TravelPlanEntity();
				entity.setTono(rs.getString(1));
				entity.setName(rs.getString(2));
				entity.setFromdate(rs.getString(3));
				entity.setTodate(rs.getString(4));
				entity.setDestination(rs.getString(5));
				entity.setFood(rs.getDouble(6));
				entity.setAllowance(rs.getDouble(7));
				entity.setAccommodation(rs.getDouble(8));
				entity.setTransportation(rs.getDouble(9));
				entity.setPerdiem(rs.getDouble(10));
				entity.setStatus(rs.getString(11));
				entity.setOfficername(rs.getString(12));
				entity.setSvtotal(rs.getDouble(13));
				entity.setPlanid(rs.getInt(14));
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

	public ArrayList<TravelPlanEntity> getTravelPlanList(){
		ArrayList<TravelPlanEntity> list = null;
		try {
			list = new ArrayList<TravelPlanEntity>();
			cs = conn.prepareCall(SelectPlan);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.DECIMAL);
			cs.registerOutParameter(6, Types.DECIMAL);
			cs.registerOutParameter(7, Types.DECIMAL);
			cs.registerOutParameter(8, Types.DECIMAL);
			cs.registerOutParameter(9, Types.DECIMAL);
			cs.registerOutParameter(10, Types.VARCHAR);
			cs.registerOutParameter(11, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelPlanEntity entity = new TravelPlanEntity();
				entity.setId(rs.getInt(1));
				entity.setFromdate(rs.getString(2));
				entity.setTodate(rs.getString(3));
				entity.setTono(rs.getString(4));
				entity.setFood(rs.getDouble(5));
				entity.setAllowance(rs.getDouble(6));
				entity.setAccommodation(rs.getDouble(7));
				entity.setTransportation(rs.getDouble(8));
				entity.setPerdiem(rs.getDouble(9));
				entity.setStatus(rs.getString(10));
				entity.setComment(rs.getString(11));
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

	public ArrayList<TravelPlanListEntity> getTravelPlanListByToNo(String tono, String tpid){
		ArrayList<TravelPlanListEntity> list = null;
		try {
			list = new ArrayList<TravelPlanListEntity>();
			cs = conn.prepareCall(SelectPlanList);
			cs.setString(24, tpid);
			cs.setString(23, tono);
			cs.registerOutParameter(1, Types.INTEGER);//id
			cs.registerOutParameter(2, Types.VARCHAR);//tno
			cs.registerOutParameter(3, Types.VARCHAR);//pcn
			cs.registerOutParameter(4, Types.BLOB);//fle
			cs.registerOutParameter(5, Types.VARCHAR);//typ
			cs.registerOutParameter(6, Types.VARCHAR);//serv
			cs.registerOutParameter(7, Types.DECIMAL);//samnt
			cs.registerOutParameter(8, Types.VARCHAR);//from
			cs.registerOutParameter(9, Types.VARCHAR);//to
			cs.registerOutParameter(10, Types.VARCHAR);//pckup
			cs.registerOutParameter(11, Types.VARCHAR);//dropoff
			cs.registerOutParameter(12, Types.VARCHAR);//chcin
			cs.registerOutParameter(13, Types.VARCHAR);//chckout
			cs.registerOutParameter(14, Types.VARCHAR);//deptre
			cs.registerOutParameter(15, Types.VARCHAR);//retrn
			cs.registerOutParameter(16, Types.INTEGER);//stopover
			cs.registerOutParameter(17, Types.VARCHAR);//from
			cs.registerOutParameter(18, Types.VARCHAR);//to
			cs.registerOutParameter(19, Types.VARCHAR);//vendor
			cs.registerOutParameter(20, Types.VARCHAR);//desc
			cs.registerOutParameter(21, Types.DECIMAL);//amnt
			cs.registerOutParameter(22, Types.VARCHAR);//sprovi
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelPlanListEntity entity = new TravelPlanListEntity();
				entity.setId(rs.getInt(1));
				entity.setTono(rs.getString(2));
				entity.setPcn(rs.getString(3));
				entity.setFile(rs.getString(4));
				entity.setType(rs.getString(5));
				entity.setService(rs.getString(6));
				entity.setAmount(rs.getDouble(7));
				entity.setCfrom(rs.getString(8));
				entity.setCto(rs.getString(9));
				entity.setPickup(rs.getString(10));
				entity.setDropoff(rs.getString(11));
				entity.setCheckin(rs.getString(12));
				entity.setCheckout(rs.getString(13));
				entity.setDeparture(rs.getString(14));
				entity.setReturns(rs.getString(15));
				entity.setStopover(rs.getInt(16));
				entity.setFfrom(rs.getString(17));
				entity.setFto(rs.getString(18));
				entity.setVendor(rs.getString(19));
				entity.setDescription(rs.getString(20));
				entity.setMiscamount(rs.getDouble(21));
				entity.setServiceprovider(rs.getString(22));
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
	
	public ArrayList<TravelPlanEntity> getTravelPlanEmployee(String tono){
		ArrayList<TravelPlanEntity> list = null;
		try {
			list = new ArrayList<TravelPlanEntity>();
			cs = conn.prepareCall(SelectPlan_2);
			cs.setString(3, tono);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelPlanEntity entity = new TravelPlanEntity();
				entity.setId(rs.getInt(1));
				entity.setName(rs.getString(2));
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
	
	public ArrayList<TravelPlanEntity> getTravelPlanListReport(){
		ArrayList<TravelPlanEntity> list = null;
		try {
			list = new ArrayList<TravelPlanEntity>();
			cs = conn.prepareCall(SelectPlanReport);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.DECIMAL);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelPlanEntity entity = new TravelPlanEntity();
				entity.setTono(rs.getString(1));
				entity.setName(rs.getString(2));
				entity.setFromdate(rs.getString(3));
				entity.setTodate(rs.getString(4));
				entity.setDestination(rs.getString(5));
				entity.setSvtotal(rs.getDouble(6));
				entity.setStatus(rs.getString(7));
				entity.setOfficername(rs.getString(8));
				entity.setId(rs.getInt(9));
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
	
	public ArrayList<TravelPlanEntity> getTravelPlanListReportEmployee(int empid){
		ArrayList<TravelPlanEntity> list = null;
		try {
			list = new ArrayList<TravelPlanEntity>();
			cs = conn.prepareCall(SelectPlanReportEmployee);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.DECIMAL);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.setInt(9, empid);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				TravelPlanEntity entity = new TravelPlanEntity();
				entity.setTono(rs.getString(1));
				entity.setName(rs.getString(2));
				entity.setFromdate(rs.getString(3));
				entity.setTodate(rs.getString(4));
				entity.setDestination(rs.getString(5));
				entity.setSvtotal(rs.getDouble(6));
				entity.setStatus(rs.getString(7));
				entity.setOfficername(rs.getString(8));
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
