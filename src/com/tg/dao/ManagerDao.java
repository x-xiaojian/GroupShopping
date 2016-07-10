package com.tg.dao;

import com.tg.tools.JDBConnection;
import java.sql.*;
import java.util.*;

import com.tg.form.ManagerForm;

//对会员表的操作
public class ManagerDao {
  private Connection connection = null; //定义连接的对象
  private PreparedStatement ps = null; //定义预准备的对象
  private JDBConnection jdbc = null; //定义数据库连接对象
  public ManagerDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection; //利用构造方法取得数据库连接
  }


//全部查询信息操作
  public List selectManager() {
    List list = new ArrayList();
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement("select * from TG_manager order by id_manager DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
    	manager = new ManagerForm();
    	manager.setId_manager(rs.getInt(1));
    	manager.setName(rs.getString(2));
    	manager.setUsename(rs.getString(3));
    	manager.setPassword(rs.getString(4));
    	manager.setSign(rs.getInt(5));
        list.add(manager);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//对管理员表的查询方法
public void insertManager(ManagerForm form) {
  try {

    ps = connection.prepareStatement("insert into TG_manager values (?,?,?,?)");
    ps.setString(1, form.getUsename());
    ps.setString(2, form.getPassword());
    ps.setString(3, form.getName());
    ps.setInt(4, 0);
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException ex) {
  }
}

//修改管理员密码的方法
public void updateManagerPassword(String password,int id) {
  try {
    ps = connection.prepareStatement("update TG_manager set password=? where id_manager=?");
    ps.setString(1, password);
    ps.setInt(2,id);
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException ex) {
  }
}


//删除管理员的操作
public void deleteManager(int id) {
  try {
    ps = connection.prepareStatement("delete from TG_manager where id_manager=?");
    ps.setInt(1, id);
    ps.executeUpdate();
    ps.close();
  }
  catch (SQLException ex) {
  }
}


//以管理员账号为条件查询管理员信息
public ManagerForm selectOne(String account) {
  ManagerForm manager = null;
  try {
    ps = connection.prepareStatement("select * from TG_manager where usename=?");
    ps.setString(1, account);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
    	manager = new ManagerForm();
    	manager.setId_manager(rs.getInt(1));
    	manager.setName(rs.getString(2));
    	manager.setUsename(rs.getString(3));
    	manager.setPassword(rs.getString(4));
    	manager.setSign(rs.getInt(5));
    }
  }
  catch (SQLException ex) {
  }
  return manager;
}



}
