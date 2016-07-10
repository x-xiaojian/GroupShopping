package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;
import com.tg.form.TypeForm;

//对城市表的操作
public class TypeDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public TypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }


//全部查询的操作
  public List selectType() {
	    List list = new ArrayList();
	    TypeForm sort = null;
	    try {
	      this.ps = connection.prepareStatement("select * from tg_type order by typ_id DESC");
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	sort = new TypeForm();
	    	sort.setTyp_id(rs.getInt(1));
	    	sort.setTyp_name(rs.getString(2));
	    	sort.setCreat_time(rs.getString(3));
	        list.add(sort);
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return list;
	  }

//全部查询的操作
  public TypeForm selectOneType(int id) {
	    TypeForm sort = null;
	    try {
	      this.ps = connection.prepareStatement("select * from tg_type where typ_id=? order by typ_id DESC");
	      ps.setInt(1, id);
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	    	sort = new TypeForm();
	    	sort.setTyp_id(rs.getInt(1));
	    	sort.setTyp_name(rs.getString(2));
	    	sort.setCreat_time(rs.getString(3));
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return sort;
	  }


}
