package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;

import com.tg.form.GoodsForm;
import com.tg.form.MemberForm;
import com.tg.form.CityForm;

//�Գ��б�Ĳ���
public class CityDao {
  private Connection connection = null; //�������ӵĶ���
  private PreparedStatement ps = null; //����Ԥ׼���Ķ���
  private JDBConnection jdbc = null; //�������ݿ����Ӷ���
  public CityDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
  }


//ȫ����ѯ�Ĳ���
  public List selectCity() {
	    List list = new ArrayList();
	    CityForm city = null;
	    try {
	      this.ps = connection.prepareStatement("select * from city order by cityID DESC");
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        city = new CityForm();
	        city.setCityID(rs.getInt(1));
	        city.setCityName(rs.getString(2));
	        city.setProID(rs.getInt(3));
	        list.add(city);
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return list;
	  }

//�Գ�����ؼ�Ϊ������ѯ��Ϣ
	public List selectOneProId(int proID) {
		List list = new ArrayList();
		CityForm city = null;
		try {
			this.ps = connection
					.prepareStatement("select * from city where proID=?");
			ps.setInt(1, proID);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				city = new CityForm();
				city.setCityID(rs.getInt(1));
				city.setCityName(rs.getString(2));
				city.setProID(rs.getInt(3));
				
				list.add(city);
			}
		} catch (SQLException ex) {
		}
		return list;
	}
//��ѯ����
	public CityForm selectOneCity(int cityid,int proid) {
		CityForm city = null;
	    try {
	      ps = connection.prepareStatement("select * from city where cityId=? and proId=?");
	      ps.setInt(1, cityid);
	      ps.setInt(2, proid);
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	  city = new CityForm(); 
	    	  city.setCityID(rs.getInt(1));
			  city.setCityName(rs.getString(2));
			  city.setProID(rs.getInt(3));
	      }
	    }  
	    catch (SQLException ex) {
	    }
	    return city;  
	  }
}
