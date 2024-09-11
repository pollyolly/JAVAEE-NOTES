package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.EmployeeEmergencyContactEntity;
import com.TravelEntity.EmployeeInformationEntity;
import com.TravelEntity.EmployeePassportEntity;

public class EmployeeDa {

	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;             
	private int status;
	private  String SelectAllById = "{CALL sp_employee_select_id(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private  String SelectAll = "{CALL sp_employee_read(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private  String Insert = "{CALL sp_employee_create(?,?,?,?,?,?,?,?,?,?,?)}";
	private  String Update = "{CALL sp_employee_update(?,?,?,?,?,?,?,?,?,?,?,?)}";
	private  String Employee = "{CALL sp_r_employee(?,?)}";
	private String insertCont = "{CALL sp_employeecontact_create(?,?,?,?,?)}";
	private String updateCont = "{CALL sp_employeecontact_update(?,?,?,?,?,?)}";
	private String selectContList = "{CALL sp_employeecontact_read(?,?,?,?,?,?,?)}";
	private String selectContListById = "{CALL sp_employeecontact_select_id(?,?,?,?,?,?,?,?,?,?)}";
	private String insertPassport = "{CALL sp_employeepassport_create(?,?,?,?)}";
	private String updatePassport = "{CALL sp_employeepassport_udpate(?,?,?,?,?)}";
	private String selectPassport = "{CALL sp_employeepassport_read(?,?,?,?,?,?,?)}";
	private String selectPassportById = "{CALL sp_employeepassport_select_id(?,?,?,?,?,?,?,?,?)}";
	public EmployeeDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//PASSPORT
	public int insertEmployeePassport(EmployeePassportEntity entity){
		try {
			cs = conn.prepareCall(insertPassport);
			cs.setString(1, entity.getPassportno());
			cs.setString(2, entity.getExpirydate());
			cs.setInt(3, entity.getStatusid());
			cs.setInt(4, entity.getEmployeeid());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	
	public int updateEmployeePassport(EmployeePassportEntity entity){
		try {
			cs = conn.prepareCall(updatePassport);
			cs.setString(1, entity.getPassportno());
			cs.setString(2, entity.getExpirydate());
			cs.setInt(3, entity.getStatusid());
			cs.setInt(4, entity.getEmployeeid());
			cs.setInt(5, entity.getPassportid());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	
	public ArrayList<EmployeePassportEntity> getEmployeePassportList(){
		ArrayList<EmployeePassportEntity> list = null;
		try {
			list = new ArrayList<EmployeePassportEntity>(); 
			cs = conn.prepareCall(selectPassport);
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
				EmployeePassportEntity entity = new EmployeePassportEntity();
				entity.setPassportid(rs.getInt(1));
				entity.setEmployee(rs.getString(2));
				entity.setDepartment(rs.getString(3));
				entity.setPassportno(rs.getString(4));
				entity.setExpirydate(rs.getString(5));
				entity.setStatus(rs.getString(6));
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
	
	public ArrayList<EmployeePassportEntity> getEmployeePassportById(int id){
		ArrayList<EmployeePassportEntity> list = null;
		try {
			list = new ArrayList<EmployeePassportEntity>(); 
			cs = conn.prepareCall(selectPassportById);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.INTEGER);
			cs.setInt(9, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				EmployeePassportEntity entity = new EmployeePassportEntity();
				entity.setPassportid(rs.getInt(1));
				entity.setEmployee(rs.getString(2));
				entity.setDepartment(rs.getString(3));
				entity.setPassportno(rs.getString(4));
				entity.setExpirydate(rs.getString(5));
				entity.setStatus(rs.getString(6));
				entity.setEmployeeid(rs.getInt(7));
				entity.setStatusid(rs.getInt(8));
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
	
	//PASSPORT
	//CONTACT
	public int insertEmployeeContact(EmployeeEmergencyContactEntity entity){
		try {
			cs = conn.prepareCall(insertCont);
			cs.setString(1, entity.getContact());
			cs.setString(2, entity.getPersonname());
			cs.setString(3, entity.getRelationship());
			cs.setInt(4, entity.getStatusid());
			cs.setInt(5, entity.getEmployeeid());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public int updateEmployeeContact(EmployeeEmergencyContactEntity entity){
		try {
			cs = conn.prepareCall(updateCont);
			cs.setString(1, entity.getContact());
			cs.setString(2, entity.getPersonname());
			cs.setString(3, entity.getRelationship());
			cs.setInt(4, entity.getStatusid());
			cs.setInt(5, entity.getEmployeeid());
			cs.setInt(6, entity.getContactid());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	
	public ArrayList<EmployeeEmergencyContactEntity> getEmployeeContactList(){
		ArrayList<EmployeeEmergencyContactEntity> list = null;
		try {
			list = new ArrayList<EmployeeEmergencyContactEntity>(); 
			cs = conn.prepareCall(selectContList);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				EmployeeEmergencyContactEntity entity = new EmployeeEmergencyContactEntity();
				entity.setContactid(rs.getInt(1));
				entity.setEmployee(rs.getString(2));
				entity.setDepartment(rs.getString(3));
				entity.setContact(rs.getString(4));
				entity.setPersonname(rs.getString(5));
				entity.setRelationship(rs.getString(6));
				entity.setStatus(rs.getString(7));
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
	
	public ArrayList<EmployeeEmergencyContactEntity> getEmployeeContactById(int id){
		ArrayList<EmployeeEmergencyContactEntity> list = null;
		try {
			list = new ArrayList<EmployeeEmergencyContactEntity>(); 
			cs = conn.prepareCall(selectContListById);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.INTEGER);
			cs.registerOutParameter(9, Types.INTEGER);
			cs.setInt(10, id);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				EmployeeEmergencyContactEntity entity = new EmployeeEmergencyContactEntity();
				entity.setContactid(rs.getInt(1));
				entity.setEmployee(rs.getString(2));
				entity.setDepartment(rs.getString(3));
				entity.setContact(rs.getString(4));
				entity.setPersonname(rs.getString(5));
				entity.setRelationship(rs.getString(6));
				entity.setStatus(rs.getString(7));
				entity.setStatusid(rs.getInt(8));
				entity.setEmployeeid(rs.getInt(9));
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
	//CONTACT
//INSERT
	public int insertEmployeeInformation(EmployeeInformationEntity entity){
		
		try {
			cs = conn.prepareCall(Insert);
			cs.setString(1, entity.getFirstname());
			cs.setString(2, entity.getMiddlename());
			cs.setString(3, entity.getLastname());
			cs.setString(4, entity.getGender());
			cs.setString(5, entity.getBirthdate());
			cs.setString(6, entity.getContact());
			cs.setString(7, entity.getEmail());
			cs.setString(8, entity.getAddress());
			cs.setInt(9, entity.getDepartmentid());
			cs.setInt(10, entity.getPositionid());
			cs.setInt(11, entity.getStatusid());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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

//INSERT
	public int updateEmployeeInformation(EmployeeInformationEntity entity){
		try {
			cs = conn.prepareCall(Update);
			cs.setString(1, entity.getFirstname());
			cs.setString(2, entity.getMiddlename());
			cs.setString(3, entity.getLastname());
			cs.setString(4, entity.getGender());
			cs.setString(5, entity.getBirthdate());
			cs.setString(6, entity.getContact());
			cs.setString(7, entity.getEmail());
			cs.setString(8, entity.getAddress());
			cs.setInt(9, entity.getDepartmentid());
			cs.setInt(10, entity.getPositionid());
			cs.setInt(11, entity.getStatusid());
			cs.setInt(12, entity.getEmployeeid());
			status = cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public ArrayList<EmployeeInformationEntity> getAllEmployeeInformation(){
		ArrayList<EmployeeInformationEntity> list = null;
		try {
			list = new ArrayList<EmployeeInformationEntity>(); 
			cs = conn.prepareCall(SelectAll);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			cs.registerOutParameter(11, Types.INTEGER);
			cs.registerOutParameter(12, Types.INTEGER);
			cs.registerOutParameter(13, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				EmployeeInformationEntity entity = new EmployeeInformationEntity();
				entity.setEmployeeid(rs.getInt(1));
				entity.setEmployee(rs.getString(2));
				entity.setGender(rs.getString(3));
				entity.setBirthdate(rs.getString(4));
				entity.setContact(rs.getString(5));
				entity.setEmail(rs.getString(6));
				entity.setAddress(rs.getString(7));
				entity.setDepartment(rs.getString(8));
				entity.setPosition(rs.getString(9));
				entity.setStatus(rs.getString(10));
				entity.setDepartmentid(rs.getInt(11));
				entity.setPositionid(rs.getInt(12));
				entity.setStatusid(rs.getInt(13));
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
	
	public ArrayList<EmployeeInformationEntity> getAllEmployeeInformationById(int id){
		ArrayList<EmployeeInformationEntity> list = null;
		try {
			list = new ArrayList<EmployeeInformationEntity>(); 
			cs = conn.prepareCall(SelectAllById);
			cs.setInt(16, id);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			cs.registerOutParameter(11, Types.VARCHAR);
			cs.registerOutParameter(12, Types.VARCHAR);
			cs.registerOutParameter(13, Types.INTEGER);
			cs.registerOutParameter(14, Types.INTEGER);
			cs.registerOutParameter(15, Types.INTEGER);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				EmployeeInformationEntity entity = new EmployeeInformationEntity();
				entity.setEmployeeid(rs.getInt(1));
				entity.setLastname(rs.getString(2));
				entity.setFirstname(rs.getString(3));
				entity.setMiddlename(rs.getString(4));
				entity.setGender(rs.getString(5));
				entity.setBirthdate(rs.getString(6));
				entity.setContact(rs.getString(7));
				entity.setEmail(rs.getString(8));
				entity.setAddress(rs.getString(9));
				entity.setDepartment(rs.getString(10));
				entity.setPosition(rs.getString(11));
				entity.setStatus(rs.getString(12));
				entity.setDepartmentid(rs.getInt(13));
				entity.setPositionid(rs.getInt(14));
				entity.setStatusid(rs.getInt(15));
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
	public ArrayList<EmployeeInformationEntity> getEmployee(){
		ArrayList<EmployeeInformationEntity> list = null;
		try {
			list = new ArrayList<EmployeeInformationEntity>(); 
			cs = conn.prepareCall(Employee);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
				EmployeeInformationEntity entity = new EmployeeInformationEntity();
				entity.setEmployeeid(rs.getInt(1));
				entity.setEmployee(rs.getString(2));
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
