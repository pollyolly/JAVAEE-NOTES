package com.TravelDa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.Connector.DbConnect;
import com.TravelEntity.ApprovingOfficerEntity;
import com.TravelEntity.SupportDocumentEntity;

public class SupportDocumentDa {
	private  Connection conn = null;
	private CallableStatement cs = null;
	private  ResultSet rs = null;
	private int status;
	private String insertSupport = "{CALL sp_t_supportdocument_create(?,?,?,?)}";
	private String supportread = "{CALL sp_t_supportdocument_read(?,?,?,?,?)}";
	private String updateSupport = "UPDATE ptms_t_supportdocument SET statusid = ? WHERE id = ?;";
	public SupportDocumentDa() {
		// TODO Auto-generated constructor stub
		try {
			conn = DbConnect.getConnection();
			//myAcc = new AccountEntity();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public int insertSupportDocument(SupportDocumentEntity entity){
		try {
			cs = conn.prepareCall(insertSupport);
			cs.setString(1, entity.getTono());
			cs.setString(2, entity.getDescription());
			cs.setString(3, entity.getFile());
			cs.setInt(4, entity.getStatusid());
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

	public int updateSupportDocument(SupportDocumentEntity entity){
		try {
			cs = conn.prepareCall(updateSupport);
			cs.setInt(2, entity.getId());
			cs.setInt(1, entity.getStatusid());
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
	
	public ArrayList<SupportDocumentEntity> getSupportDocument(){
		ArrayList<SupportDocumentEntity> list = null;
		try {
			list = new ArrayList<SupportDocumentEntity>(); 
			cs = conn.prepareCall(supportread);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.execute();
			rs = cs.getResultSet();
			while(rs.next()){
			SupportDocumentEntity entity = new SupportDocumentEntity();
			entity.setId(rs.getInt(1));
			entity.setTono(rs.getString(2));
			entity.setDescription(rs.getString(3));
			entity.setFile(rs.getString(4));
			entity.setStatus(rs.getString(5));
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
	
	
}
