package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;

import com.tg.form.PromaryForm;
import com.tg.form.MemberForm;

//对会员表的操作
public class PromaryDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public PromaryDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }


//全部查询的操作
  public List selectPromary() {
	    List list = new ArrayList();
	    PromaryForm promary = null;
	    try {
	      this.ps = connection.prepareStatement("select * from promary order by proID DESC");
	      ResultSet rs = ps.executeQuery();
	      while (rs.next()) {
	        promary = new PromaryForm();
	        promary.setProID(rs.getInt(1));
	        promary.setProName(rs.getString(2));
	        list.add(promary);
	      }
	    }
	    catch (SQLException ex) {
	    }
	    return list;
	  }

  //以数据库流水号为条件查询省份的名称
  public String selectName(int id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement("select * from promary where proId=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("ProName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

}
