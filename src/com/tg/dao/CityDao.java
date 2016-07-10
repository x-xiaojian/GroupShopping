package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;

import com.tg.form.GoodsForm;
import com.tg.form.MemberForm;
import com.tg.form.CityForm;

//对城市表的操作
public class CityDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public CityDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }


//全部查询的操作
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

//以城市外关键为条件查询信息
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
//查询城市
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
